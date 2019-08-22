import { Router } from '@angular/router';
import { OrdenGastos } from './../model/OrdenGasto';
import { Component, OnInit } from '@angular/core';
import { OrdenGastoService } from '../services/OrdenGasto.service';
import { CertificadoPresupuestario } from './../model/CertificadoPresupuestario';
import {CertificadoPresupuestarioService} from '../services/CertificadoPresupuestario.service'
import { HttpClient } from '@angular/common/http';
import {Contrato} from './../model/Contrato';
import {ContratoService} from '../services/Contrato.service';
import jsPDF from 'jsPDF';


@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {
  title = 'PDFs';
  docPdf:jsPDF;
  OrdenGastoService: any;
  ordenGastos: OrdenGastos[];
  ContratoService:any;
  contrato: Contrato[];
  certificadoPresupuestario: CertificadoPresupuestario[];
  CertificadoPresupuestarioService:any;
  date: Date;
  constructor(
    private ordenGastoDataService: OrdenGastoService,
    private contratoDataService:ContratoService,
    private certificadoPresupuestarioDataService: CertificadoPresupuestarioService,
    private router: Router
  ) { }

  ngOnInit() {
    this.buscarOrdenGasto();
    this.buscarContrato();
    this.buscarCertificado();
  }
  buscarOrdenGasto() {
    this.ordenGastoDataService.buscarOrdenGasto().subscribe(respuesta => {
      this.ordenGastos = respuesta;
      console.log(this.ordenGastos);
    },
    () => {
      }
    );
  }
  Borrar(ordenGastos: OrdenGastos) {
    if (ordenGastos === undefined) {return; }
    this.ordenGastoDataService.deleteOrdenGasto(ordenGastos)
    .subscribe( respuesta  => {
      this.ordenGastos = respuesta;
      console.log (respuesta)
        alert('borrado');
      });
  }
  Editar(ordenGastos: OrdenGastos): void {
    localStorage.removeItem('id_orden');
    localStorage.setItem('id_orden', ordenGastos.id_orden.toString());
    this.router.navigate(['editar']);
  }
 buscarContrato() {
    this.contratoDataService.buscarContrato().subscribe(respuesta => {
      this.contrato = respuesta;
      console.log(this.contrato);
    },
    () => {
      }
    );
    }
    buscarCertificado() {
      this.certificadoPresupuestarioDataService.buscarCertificado().subscribe(respuesta => {
        this.certificadoPresupuestario = respuesta;
        console.log(this.certificadoPresupuestario);
      },
      () => {
        }
      );
    }
     pdf(){
    let x = 25
    let y = 25
    let altoTotal=290
    let anchoTotal=210
    const marDer=25
    const marIzq=25
    const marSup=25
    const marInf=25
    let interlineado=1
    let anchoUso= anchoTotal-marIzq-marDer
    let altoUso=altoTotal-marSup-marInf
    let textSize=16
    let ancho=50
    let texto1='Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularasddddsdsd.'
    let doc=new jsPDF({
      orientation:'P',
      unit:'mm',
      format: 'A4',
      compress:true,
    })
    doc.setFontSize(textSize);
    for(let i=0;i<=20;i++){
      let espacio = doc.splitTextToSize(texto1,altoUso);
      if(x==25){
        doc.text(espacio,x,y,{maxWidth:ancho},interlineado)
        var dim = doc.getStringUnitWidth('espacio')*textSize;
        var anchoParrafo= Math.ceil(dim)+(textSize*0.3515)*interlineado;
        x+= anchoParrafo
      }else if(x<anchoUso){
        anchoParrafo = Math.ceil(dim)+(textSize*0.3515)*interlineado;
        if((x+anchoParrafo)<anchoUso){
          doc.text(espacio,x,y,{maxWidth:ancho},anchoParrafo)
          x+=anchoParrafo
        }else{
          doc.text(espacio,x,y,{maxWidth:ancho})
          x+=anchoParrafo
          doc.addPage()
          y=25
          x=25
        }
      }
    }

  doc.save('parrafoPDF.pdf')
  }
}
