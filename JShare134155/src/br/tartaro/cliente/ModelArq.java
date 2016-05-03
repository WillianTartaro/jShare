package br.tartaro.cliente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.table.AbstractTableModel;

import br.dagostini.jshare.comum.pojos.Arquivo;
import br.dagostini.jshare.comun.Cliente;

public class ModelArq extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	Map<Cliente, List<Arquivo>> listaArquivos = new HashMap<>();
	private Object[][] matriz;
	private int linhas;
	
	public ModelArq(Map<Cliente, List<Arquivo>> lista) {

	this.listaArquivos = lista;
	linhas = 0;
	
	for (Entry<Cliente, List<Arquivo>> e : listaArquivos.entrySet()) 
		linhas += e.getValue().size();
	
	matriz = new Object[linhas][5];
	int linha = 0;
	
	for (Entry<Cliente, List<Arquivo>> e : listaArquivos.entrySet()) {
		for (Arquivo arq : e.getValue()) {
			matriz[linha][0] = arq.getNome();
			matriz[linha][1] = arq.getTamanho();
			matriz[linha][2] = e.getKey().getNome();
			matriz[linha][3] = e.getKey().getIp();
			matriz[linha][4] = e.getKey().getPorta();
			
			linha++;
			
		}
		
	}
		
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return linhas;
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0: return matriz[row][0];
		case 1: return matriz[row][1];
		case 2: return matriz[row][2];
		case 3: return matriz[row][3];
		default: return matriz[row][4];
		}
		
	}
	
	@Override
	public String getColumnName(int col){
		switch (col) {
		case 0: return "Arquivo";
		case 1: return "Tamanho";
		case 2: return "Cliente";
		case 3: return "Ip";
		default: return "Porta";
		}
	}

}
