﻿using System;
using System.Windows.Forms;
using CapaNegocio_CONTROLADOR;
using CapaEntidades_CONTROLADOR;
using System.Windows.Forms.DataVisualization.Charting;

namespace CapaPresentacion_VISTA_
{
    public partial class Form1 : Form
    {
   

        private TableLayoutPanel tlp;
        private Chart grafico1;
        private Chart grafico2;

        public Form1()
        {
            InitializeComponent();
            tlp = tlpGrafico;
            grafico1 = chartProdxCategoria;
            grafico2 = chartProdPreferidos;
            tlp.Controls.Remove(grafico2);
            tlp.Controls.Remove(grafico1);
        }
        private void button1_Click(object sender, EventArgs e)
        {
            tlp.Controls.Remove(grafico2);
            tlp.Controls.Remove(grafico1);
            tlp.Controls.Add(grafico1, 0, 0);
            grafico1.Visible = true;
            grafico2.Visible = false;

        }
        private void button2_Click(object sender, EventArgs e)
        {
            tlp.Controls.Remove(grafico2);
            tlp.Controls.Remove(grafico1);
            tlp.Controls.Add(grafico2, 0, 0);
            grafico2.Visible = true;
            grafico1.Visible = false;

        }

        private void button3_Click(object sender, EventArgs e)
        {
            tlp.Controls.Remove(grafico2);
            tlp.Controls.Remove(grafico1);
        }
        private void Form1_Load(object sender, EventArgs e)
        {
          
            Dashboard();
        }


        private void Dashboard()
        {
            N_Dashboard neg = new N_Dashboard();
            E_Dashboard obj = new E_Dashboard();
            neg.Dashboard(obj);

            // recuperar datos de la entidad para cargar los datos del dashboard
            chartProdPreferidos.Series[0].Points.DataBindXY(obj.Producto1, obj.Cant1);
            chartProdxCategoria.Series[0].Points.DataBindXY(obj.Categoria1, obj.CantProd1);
            lblCantCateg.Text = obj.CantCategorias1;
            lblCantProd.Text = obj.CantProductos1;
            lblCantClient.Text = obj.CantClientes1;
            lblCantEmple.Text = obj.CantEmpleados1;
            lblCantMarcas.Text = obj.CantMarcas1;
            lblCantProve.Text = obj.CantProveedores1;
            lblTotalVentas.Text = obj.TotalVentas;
        }

        
    }
}
