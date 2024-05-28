package ThanhThuy_Graph_Theory;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Graph {
	ArrayList<Vertex> danhSachDinh;
	ArrayList<Edge> danhSachCanh;
	ArrayList<ArrayList<Integer>> mtk;

	public Graph() {
		this.danhSachDinh = new ArrayList<>();
		this.danhSachCanh = new ArrayList<>();
		this.mtk = new ArrayList<>();
	}

	public ArrayList<Vertex> getDanhSachDinh() {
		return danhSachDinh;
	}

	public void setDanhSachDinh(ArrayList<Vertex> danhSachDinh) {
		this.danhSachDinh = danhSachDinh;
	}

	public ArrayList<Edge> getDanhSachCanh() {
		return danhSachCanh;
	}

	public void setDanhSachCanh(ArrayList<Edge> danhSachCanh) {
		this.danhSachCanh = danhSachCanh;
	}

	public ArrayList<ArrayList<Integer>> getMtk() {
		return mtk;
	}

	public void setMtk(ArrayList<ArrayList<Integer>> mtk) {
		this.mtk = mtk;
	}

	// them dinh
	public void themDinh(Ellipse2D el) {
		if (mtk.size() == 0) {
			mtk.add(new ArrayList<Integer>());
			mtk.get(0).add(0);
			danhSachDinh.add(new Vertex(mtk.size() - 1, mtk.size() - 1, new ArrayList<Vertex>(), el));
			return;
		}
		for(int i=0;i<mtk.size();i++)
			mtk.get(i).add(0);
		ArrayList<Integer> dongmoi= new ArrayList<Integer>();
		for (int i=0;i<mtk.size()+1;i++)
			dongmoi.add(0);
		mtk.add(dongmoi);
		
		danhSachDinh.add(new Vertex(mtk.size() - 1, mtk.size() - 1, new ArrayList<Vertex>(), el));
	}

	public boolean themCanhVoHuong(Vertex diemdau1, Vertex diemdau2, Line2D line2d, String weight) {
		int cenX = (int) ((diemdau1.getEl().getCenterX() + diemdau2.getEl().getCenterX()) /2);
		int cenY = (int) ((diemdau1.getEl().getCenterY() + diemdau2.getEl().getCenterY()) /2);
		if(diemdau1.index < mtk.size() && diemdau2.index < mtk.size() && 
				mtk.get(diemdau1.index).get(diemdau2.index) == 0 && 
				mtk.get(diemdau2.index).get(diemdau1.index) == 0) {
			
			mtk.get(diemdau1.index).set(diemdau2.index, 1);
			mtk.get(diemdau2.index).set(diemdau1.index, 1);
			
			danhSachCanh.add(new Edge(diemdau1, diemdau2, line2d, cenX, cenY, weight));
			danhSachCanh.add(new Edge(diemdau2, diemdau1, line2d, cenX, cenY, weight));
			
			diemdau1.danhSachKe.add(diemdau2);
			diemdau2.danhSachKe.add(diemdau1);
			return true;
		}else {
			return false;
		}
	}
	public boolean themCanhCoHuong(Vertex diemdau1, Vertex diemdau2, Line2D line2d, String weight) {
		int cenX = (int) ((diemdau1.getEl().getCenterX() + diemdau2.getEl().getCenterX()) /2);
		int cenY = (int) ((diemdau1.getEl().getCenterY() + diemdau2.getEl().getCenterY()) /2);
		if(diemdau1.index < mtk.size() && diemdau2.index < mtk.size() && 
				mtk.get(diemdau1.index).get(diemdau2.index) == 0 ) {
			mtk.get(diemdau1.index).set(diemdau2.index, 1);
			
			danhSachCanh.add(new Edge(diemdau1, diemdau2, line2d, cenX, cenY, weight));
			diemdau1.danhSachKe.add(diemdau2);
			return true;
		}else {
			return false;
		}
	}
	
	
	public void resetEl(Ellipse2D el, int index) {
		danhSachDinh.get(index).setEl(el);
		
	}
	
	public void resetEdge(Line2D line2d, int index, int cenX, int cenY) {
		danhSachCanh.get(index).setLine2D(line2d);
		danhSachCanh.get(index).setCenterEdgeX(cenX);
		danhSachCanh.get(index).setCenterEdgeY(cenY);
	}

	public Vertex isVertex(int nameOtherV) {
		Vertex oVertex= null;
		for(Vertex v: danhSachDinh) {
			if(v.ten == nameOtherV) oVertex =v;
		}
		return oVertex;
	}
}
