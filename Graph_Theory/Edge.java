package ThanhThuy_Graph_Theory;

import java.awt.geom.Line2D;

public class Edge {
	Vertex diemdau1;
	Vertex diemdau2;
	Line2D line2d;
	int centerEdgeX;
	int centerEdgeY;
	String weight = "";
	
	public int getCenterEdgeX() {
		return centerEdgeX;
	}
	public void setCenterEdgeX(int centerEdgeX) {
		this.centerEdgeX = centerEdgeX;
	}
	public int getCenterEdgeY() {
		return centerEdgeY;
	}
	public void setCenterEdgeY(int centerEdgeY) {
		this.centerEdgeY = centerEdgeY;
	}
	
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public Edge(Vertex diemdau1, Vertex diemdau2, Line2D line2d, int centerEdgeX, int centerEdgeY, String weight) {
		super();
		this.diemdau1 = diemdau1;
		this.diemdau2 = diemdau2;
		this.line2d = line2d;
		this.centerEdgeX = centerEdgeX;
		this.centerEdgeY = centerEdgeY;
		this.weight = weight;
	}
	public Vertex getDiemdau1() {
		return diemdau1;
	}
	public void setDiemdau1(Vertex diemdau1) {
		this.diemdau1 = diemdau1;
	}
	public Vertex getDiemdau2() {
		return diemdau2;
	}
	public void setDiemdau2(Vertex diemdau2) {
		this.diemdau2 = diemdau2;
	}
	public void setLine2D(Line2D line2d) {
		this.line2d = line2d;
	}

	public Line2D getLine2D() {
		return line2d;
	}
	
}
