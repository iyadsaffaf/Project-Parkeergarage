package parkeersimulator.View;

import interfaces.ViewInterface;
import parkeersimulator.MVC.View;
/**
 * @author Iyad saffaf
 *
 */
public class SlidePanelView  extends View  implements ViewInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;                     
    private javax.swing.JPanel AutoInGarageSlide;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel7;
    private java.awt.Label label1;
    private javax.swing.JPanel queuSlide;
    private javax.swing.JPanel reserverenSlide;
    private javax.swing.JPanel resetSlide;
    private javax.swing.JPanel winstSlide;
	/**
	 * 
	 */
	public SlidePanelView() {
		super();
		init();
		features();
		setBackground(new java.awt.Color(0, 51, 102));
	    setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	    setAlignmentX(0.0F);
	    setAlignmentY(0.0F);
		
     
        
	}
	 
	
	



	@Override
	public void init() {
		 label1 = new java.awt.Label();
	        jLabel2 = new javax.swing.JLabel();
	        winstSlide = new javax.swing.JPanel();
	        jPanel16 = new javax.swing.JPanel();
	        jLabel7 = new javax.swing.JLabel();
	        queuSlide = new javax.swing.JPanel();
	        jPanel10 = new javax.swing.JPanel();
	        jLabel4 = new javax.swing.JLabel();
	        AutoInGarageSlide = new javax.swing.JPanel();
	        jPanel7 = new javax.swing.JPanel();
	        jLabel3 = new javax.swing.JLabel();
	        reserverenSlide = new javax.swing.JPanel();
	        jPanel12 = new javax.swing.JPanel();
	        jLabel5 = new javax.swing.JLabel();
	        resetSlide = new javax.swing.JPanel();
	        jPanel14 = new javax.swing.JPanel();
	        jLabel6 = new javax.swing.JLabel();
		
		
	}




	@Override
	public void features() {

		label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(204, 204, 204));
        label1.setName(""); // NOI18N
        label1.setText("Garage Simulator");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("V 1.1");

        winstSlide.setBackground(new java.awt.Color(0, 51, 102));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setAlignmentX(0.0F);
        jPanel16.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Het winst");

        javax.swing.GroupLayout winstSlideLayout = new javax.swing.GroupLayout(winstSlide);
        winstSlide.setLayout(winstSlideLayout);
        winstSlideLayout.setHorizontalGroup(
            winstSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winstSlideLayout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        winstSlideLayout.setVerticalGroup(
            winstSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(winstSlideLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(winstSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, winstSlideLayout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, winstSlideLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(50, 50, 50))))
        );

        queuSlide.setBackground(new java.awt.Color(0, 51, 102));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setAlignmentX(0.0F);
        jPanel10.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Het queu ");

        javax.swing.GroupLayout queuSlideLayout = new javax.swing.GroupLayout(queuSlide);
        queuSlide.setLayout(queuSlideLayout);
        queuSlideLayout.setHorizontalGroup(
            queuSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queuSlideLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        queuSlideLayout.setVerticalGroup(
            queuSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queuSlideLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(queuSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, queuSlideLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, queuSlideLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(47, 47, 47))))
        );

        AutoInGarageSlide.setBackground(new java.awt.Color(0, 51, 102));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setAlignmentX(0.0F);
        jPanel7.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Auto in de Garage");

        javax.swing.GroupLayout AutoInGarageSlideLayout = new javax.swing.GroupLayout(AutoInGarageSlide);
        AutoInGarageSlide.setLayout(AutoInGarageSlideLayout);
        AutoInGarageSlideLayout.setHorizontalGroup(
            AutoInGarageSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AutoInGarageSlideLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        AutoInGarageSlideLayout.setVerticalGroup(
            AutoInGarageSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AutoInGarageSlideLayout.createSequentialGroup()
                .addGroup(AutoInGarageSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AutoInGarageSlideLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AutoInGarageSlideLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3)))
                .addGap(284, 284, 284))
        );

        reserverenSlide.setBackground(new java.awt.Color(0, 51, 102));
        

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setAlignmentX(0.0F);
        jPanel12.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Reserveren");

        javax.swing.GroupLayout reserverenSlideLayout = new javax.swing.GroupLayout(reserverenSlide);
        reserverenSlide.setLayout(reserverenSlideLayout);
        reserverenSlideLayout.setHorizontalGroup(
            reserverenSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reserverenSlideLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        reserverenSlideLayout.setVerticalGroup(
            reserverenSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reserverenSlideLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(reserverenSlideLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        resetSlide.setBackground(new java.awt.Color(0, 51, 102));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setAlignmentX(0.0F);
        jPanel14.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Reset");

        javax.swing.GroupLayout resetSlideLayout = new javax.swing.GroupLayout(resetSlide);
        resetSlide.setLayout(resetSlideLayout);
        resetSlideLayout.setHorizontalGroup(
            resetSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resetSlideLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        resetSlideLayout.setVerticalGroup(
            resetSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resetSlideLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(resetSlideLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout slidePanelLayout = new javax.swing.GroupLayout(this);
        setLayout(slidePanelLayout);
        slidePanelLayout.setHorizontalGroup(
            slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AutoInGarageSlide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(slidePanelLayout.createSequentialGroup()
                .addComponent(resetSlide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(reserverenSlide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(queuSlide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, slidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26))
            .addGroup(slidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(winstSlide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        slidePanelLayout.setVerticalGroup(
            slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slidePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(AutoInGarageSlide, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queuSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(winstSlide, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reserverenSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(resetSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
		
	}






	public javax.swing.JPanel getAutoInGarageSlide() {
		return AutoInGarageSlide;
	}






	public void setAutoInGarageSlide(javax.swing.JPanel autoInGarageSlide) {
		AutoInGarageSlide = autoInGarageSlide;
	}






	public javax.swing.JLabel getjLabel2() {
		return jLabel2;
	}






	public void setjLabel2(javax.swing.JLabel jLabel2) {
		this.jLabel2 = jLabel2;
	}






	public javax.swing.JLabel getjLabel3() {
		return jLabel3;
	}






	public void setjLabel3(javax.swing.JLabel jLabel3) {
		this.jLabel3 = jLabel3;
	}






	public javax.swing.JLabel getjLabel4() {
		return jLabel4;
	}






	public void setjLabel4(javax.swing.JLabel jLabel4) {
		this.jLabel4 = jLabel4;
	}






	public javax.swing.JLabel getjLabel5() {
		return jLabel5;
	}






	public void setjLabel5(javax.swing.JLabel jLabel5) {
		this.jLabel5 = jLabel5;
	}






	public javax.swing.JLabel getjLabel6() {
		return jLabel6;
	}






	public void setjLabel6(javax.swing.JLabel jLabel6) {
		this.jLabel6 = jLabel6;
	}






	public javax.swing.JLabel getjLabel7() {
		return jLabel7;
	}






	public void setjLabel7(javax.swing.JLabel jLabel7) {
		this.jLabel7 = jLabel7;
	}






	public javax.swing.JPanel getjPanel10() {
		return jPanel10;
	}






	public void setjPanel10(javax.swing.JPanel jPanel10) {
		this.jPanel10 = jPanel10;
	}






	public javax.swing.JPanel getjPanel12() {
		return jPanel12;
	}






	public void setjPanel12(javax.swing.JPanel jPanel12) {
		this.jPanel12 = jPanel12;
	}






	public javax.swing.JPanel getjPanel14() {
		return jPanel14;
	}






	public void setjPanel14(javax.swing.JPanel jPanel14) {
		this.jPanel14 = jPanel14;
	}






	public javax.swing.JPanel getjPanel16() {
		return jPanel16;
	}






	public void setjPanel16(javax.swing.JPanel jPanel16) {
		this.jPanel16 = jPanel16;
	}






	public javax.swing.JPanel getjPanel7() {
		return jPanel7;
	}






	public void setjPanel7(javax.swing.JPanel jPanel7) {
		this.jPanel7 = jPanel7;
	}






	public java.awt.Label getLabel1() {
		return label1;
	}






	public void setLabel1(java.awt.Label label1) {
		this.label1 = label1;
	}






	public javax.swing.JPanel getQueuSlide() {
		return queuSlide;
	}






	public void setQueuSlide(javax.swing.JPanel queuSlide) {
		this.queuSlide = queuSlide;
	}






	public javax.swing.JPanel getReserverenSlide() {
		return reserverenSlide;
	}






	public void setReserverenSlide(javax.swing.JPanel reserverenSlide) {
		this.reserverenSlide = reserverenSlide;
	}






	public javax.swing.JPanel getResetSlide() {
		return resetSlide;
	}






	public void setResetSlide(javax.swing.JPanel resetSlide) {
		this.resetSlide = resetSlide;
	}






	public javax.swing.JPanel getWinstSlide() {
		return winstSlide;
	}






	public void setWinstSlide(javax.swing.JPanel winstSlide) {
		this.winstSlide = winstSlide;
	}






	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
