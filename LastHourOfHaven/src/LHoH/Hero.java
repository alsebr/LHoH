package LHoH;

import java.awt.datatransfer.StringSelection;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Hero extends JPanel implements DragGestureListener,
		DragSourceListener, MouseListener {
	DragSource dragSource;



	public double getPower() {
		double tmpPower=heroStat.strp*strToPowerRatio;
		
		return tmpPower + getBonusPower();
	}

	public double getPurePower() {
		return heroStat.strp*strToPowerRatio;
	}

	public double getBonusPower() {
		return getPower_bonus();
	}

	public void setPower (double power) {
		this.power = power;
	}

	public String getStatusTip() {
		String htmltext = "";

		return htmltext;
	}

	public String getHeroTip() {
		String htmltext = "";

		return htmltext;
	}

	double exp, ttl;
	protected String name, classH;
	Image image;
	int status; // 1 - live, 0 - dead, 2 - strage
	int lvl;
	private int zone;
	private int id;
	double expNeedExp;
	private HeroStat heroStat;
	private HeroStat heroStatBonus=new HeroStat(0, 0, 0);
	
	private double power;
	private double power_bonus;
	
	double statPointForLvl;
	HeroStat statPointForLvlRatio;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	HeroStat statPointForLvlRatioPlayerModify;
	HeroStat statPointForLvlRatioFinal;
	double strToPowerRatio=2;
	double vitToTTLRatio=2;
	
	
	double deltaExp;
	double deltaPower;

	public Hero() {
		setSize(80, 105);
		setPreferredSize(new Dimension(80, 105));
		setBorder(BorderFactory.createLineBorder(Color.black));

		Random randomGenerator = new Random();
		id = randomGenerator.nextInt(32000);

		dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(this,
				DnDConstants.ACTION_COPY_OR_MOVE, this);

		this.addMouseListener(this);

	}
	
	public void addTTL (){
		
	}

	public void init(String name,  Image inImage, double inDeltaExp, double statPointPerLvl, HeroStat heroStat, HeroStat heroStatRatio,double strToPowerRatio,double vitToTTLRatio) {

		Random randomGenerator = new Random();
		id = randomGenerator.nextInt(32000);

		this.name = name;
		//this.power = power;
		this.exp = 1;
		
		this.ttl = 0;

		this.status = 1;
		this.lvl = 1;
		this.zone = 1;
		this.deltaExp = inDeltaExp;
		this.image = inImage;
		this.setHeroStat(heroStat);
		this.statPointForLvlRatio=heroStatRatio;
		this.strToPowerRatio= strToPowerRatio;
		this.vitToTTLRatio=vitToTTLRatio;
		
	}

	String getHeroName() {
		return name;
	}

	void addPower(double addP) {
		power += addP;

	}

	void addExp(double addExp) {
		exp += addExp;
	}

	void lvlUp() {
		lvl += 1;

		heroStat.intp += 3;
		heroStat.strp += 4;
		heroStat.vitp += 2;

		LHoH.gameScreen.bottomInfo.chat.addTextChat(name + " ������ " + lvl
				+ " ������, ��� ���� ������ " + (int) power);
	}

	
	double getLeftTime(){
		
		
		
		return heroStat.vitp*vitToTTLRatio-ttl;
	}
	
	double getLifeTimeTotal(){
		
		
		
		return heroStat.vitp*vitToTTLRatio;
	}
	
	void resetBonus(){
		power_bonus=0;
		heroStatBonus.strp=0;
		heroStatBonus.vitp=0;
		heroStatBonus.intp=0;
	}
	
	protected void Update() {
		
		if (status == 1) ttl += 0.017;
		if (getLeftTime() <= 0)	status = 0;

		expNeedExp = deltaExp * ((double) lvl + (double) lvl * lvl / 20);

		resetBonus();
		LHoH.gameScreen.heroAbilityStock.useAllAbilityByHero(id);
		
		if (expNeedExp < exp) {
			power += deltaPower;
			lvlUp();

		}

	}

	void setStatus(int inStatus) {
		status = inStatus;
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getClickCount() == 2) {
			LHoH.gameScreen.heroViewScreen.activate(id);
		}

	}

	void reDrow(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(image, 0, 0, null);
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(2));

		g2.setFont(new Font("Arial", Font.BOLD, 16));

		int min, sec;
		min = (int) (getLeftTime() / 60);
		sec = (int) (getLeftTime() - min * 60);

		g2.drawString(Integer.toString((int) getPower()), 15, 98);

		switch (status) {
		case 0:
			g2.drawString("DEAD", 5, 15);

			break;
		case 1:

			
			g2.drawString(min + ":" + sec, 5, 15);

			break;
		case 2:
			g2.drawString("�����", 15, 50);
			g2.drawString(min + ":" + sec, 5, 15);

			break;
		default:
			break;
		}

		// exp
		g2.setColor(Color.red);

		double expNeedExp = deltaExp * ((double) lvl + (double) lvl * lvl / 20);
		double expNeedExpPr = deltaExp
				* ((double) (lvl - 1) + (double) (lvl - 1) * (lvl - 1) / 20);
		g2.fillRect(3, 10, 3,
				(int) (90 * (exp - expNeedExpPr) / (expNeedExp - expNeedExpPr)));
	}

	public void paintComponent(Graphics g) {

		// removeAll();
		// Graphics2D g2 = (Graphics2D) g;
		// g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_ON);
		reDrow(g);
	}

	public void dragGestureRecognized(DragGestureEvent evt) {
		if (status == 1) {
			Transferable transferable = new StringSelection(
					Integer.toString(id));// !!!!!
			dragSource.startDrag(evt, DragSource.DefaultCopyDrop, transferable,
					this);
		}
	}

	public void dragEnter(DragSourceDragEvent evt) {

		// Called when the user is dragging this drag source and enters the drop
		// target

		System.out.println("Drag enter");

	}

	public void dragOver(DragSourceDragEvent evt) {

		// Called when the user is dragging this drag source and moves over the
		// drop target

		System.out.println("Drag over");

	}

	public void dragExit(DragSourceEvent evt) {

		// Called when the user is dragging this drag source and leaves the drop
		// target

		System.out.println("Drag exit");

	}

	public void dropActionChanged(DragSourceDragEvent evt) {

		// Called when the user changes the drag action between copy or move

		System.out.println("Drag action changed");

	}

	public void dragDropEnd(DragSourceDropEvent evt) {

		// Called when the user finishes or cancels the drag operation

		System.out.println("Drag action End");

	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	public HeroStat getHeroStat() {
		return heroStat;
	}

	public void setHeroStat(HeroStat heroStat) {
		this.heroStat = heroStat;
	}

	public double getPower_bonus() {
		return power_bonus;
	}

	public void setPower_bonus(double power_bonus) {
		this.power_bonus = power_bonus;
	}
	
	public void addPower_bonus(double power_bonus) {
		this.power_bonus += power_bonus;
	}

}
