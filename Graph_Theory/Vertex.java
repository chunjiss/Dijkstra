package ThanhThuy_Graph_Theory;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Vertex {
	Integer ten;
	Integer index;
	ArrayList<Vertex> danhSachKe;
	Ellipse2D el;
	
	public Vertex(Integer ten, Integer index, ArrayList<Vertex> danhSachKe, Ellipse2D el) {
		super();
		this.ten = ten;
		this.index = index;
		this.danhSachKe = danhSachKe;
		this.el = el;
	}

	public Integer getTen() {
		return index;
	}

	public void setTen(Integer ten) {
		this.ten = ten;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public ArrayList<Vertex> getDanhSachKe() {
		return danhSachKe;
	}

	public void setDanhSachKe(ArrayList<Vertex> danhSachKe) {
		this.danhSachKe = danhSachKe;
	}

	public Ellipse2D getEl() {
		return el;
	}

	public void setEl(Ellipse2D el) {
		this.el = el;
	}

	

	public boolean isVertexName(int nameOtherV) {
		if( this.ten == nameOtherV) {
			return true;
		}
		return false;
	}
	

}
