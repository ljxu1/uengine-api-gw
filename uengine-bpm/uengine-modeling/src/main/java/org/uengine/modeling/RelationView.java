package org.uengine.modeling;

import java.io.Serializable;

import javax.persistence.Id;

/**
 * @author jyj
 */
public class RelationView implements Serializable {

	private static final long serialVersionUID = 1234L;
	public final static String SHAPE_ID = "OG.shape.bpmn.C_Flow";
	private final String TERMINAL_IN_OUT = "_TERMINAL_C_INOUT_0";
	
	String id;
		@Id
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
	String shapeId;
		public String getShapeId() {
			return shapeId;
		}
		public void setShapeId(String shapeId) {
			this.shapeId = shapeId;
		}
		
	String x;
		public String getX() {
			return x;
		}
		public void setX(String x) {
			this.x = x;
		}
		
	String y;
		public String getY() {
			return y;
		}
		public void setY(String y) {
			this.y = y;
		}
		
	String width;
		public String getWidth() {
			return width;
		}
		public void setWidth(String width) {
			this.width = width;
		}
		
	String height;
		public String getHeight() {
			return height;
		}
		public void setHeight(String height) {
			this.height = height;
		}
		
	String from;
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public void setFromWithTerminal(String from) {
			this.from = from + TERMINAL_IN_OUT;
		}
		
	String to;
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public void setToWithTerminal(String to) {
			this.to = to + TERMINAL_IN_OUT;
		}
	
	String value;
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
	String geom;
		public String getGeom() {
			return geom;
		}
		public void setGeom(String geom) {
			this.geom = geom;
		}
		
	String style;
		public String getStyle() {
			return style;
		}
		public void setStyle(String style) {
			this.style = style;
		}
	String label;
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}

	IRelation relation;
		public IRelation getRelation() {
			return relation;
		}
		public void setRelation(IRelation relation) {
			this.relation = relation;
		}
		
	public RelationView(){
		setShapeId(SHAPE_ID);
	}
		 
	public RelationView(IRelation relation){
		this.setRelation(relation);
	}
	
	public void fill(Symbol symbol){
		this.setShapeId(symbol.getShapeId());
		this.setWidth(String.valueOf(symbol.getWidth()));
		this.setHeight(String.valueOf(symbol.getHeight()));
	}
	
	public static Symbol createSymbol() {
		Symbol symbol = new Symbol();
		symbol.setName("Flow");
		
		return fillSymbol(symbol);
	}
	
	public static Symbol createSymbol(Class<? extends Symbol> symbolType) {
		Symbol symbol = new Symbol();
		try {
			symbol = (Symbol)Thread.currentThread().getContextClassLoader().loadClass(symbolType.getName()).newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		symbol.setName("Flow");
		return fillSymbol(symbol);
	}

	private static Symbol fillSymbol (Symbol symbol){
		
		symbol.setShapeId(SHAPE_ID);
		symbol.setHeight(150);
		symbol.setWidth(200);
		symbol.setElementClassName(Relation.class.getName());
		symbol.setShapeType("EDGE");
		
		return symbol;
	}
}
