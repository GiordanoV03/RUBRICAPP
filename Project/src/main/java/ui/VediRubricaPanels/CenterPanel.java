package ui.VediRubricaPanels;

import controller.RubricaController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Contatto;

public class CenterPanel extends JPanel {
    private JList<Contatto> listaContatti;
    private JScrollPane scrollPane;
    
    public CenterPanel(RubricaController controller){
        setVisible(true);
        setLayout(new BorderLayout());
        setBackground(new Color(0,0,0,0));

        // Creazione della lista contatti
        DefaultListModel<Contatto> contattiModel = new DefaultListModel<>();
        for(Contatto c : controller.getContatti()){
            contattiModel.addElement(c);
        }
        
        listaContatti = new JList<>(contattiModel);
        listaContatti.setBackground(new Color(0,0,0,0));
        listaContatti.setCellRenderer(new ContattoRenderer());
        
        visualizzaContatto(controller);
        
        scrollPane = new JScrollPane(listaContatti);
        scrollPane.setBackground(new Color(0,0,0,0));
        scrollPane.setForeground(Color.black);
        add(scrollPane, BorderLayout.CENTER);
        setOpaque(false);
    }
    
    public void visualizzaContatto(RubricaController controller){
        listaContatti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    controller.vediContatto(listaContatti.getSelectedValue());
                }
            }
        });
    }

    public class ContattoRenderer extends JPanel implements ListCellRenderer<Contatto> {
        private JLabel label;

        public ContattoRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
            label = new JLabel();
            label.setFont(new Font("Colette", Font.BOLD, 18));
            label.setForeground(Color.WHITE);

            add(label);
            setOpaque(false);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
        
            Color viola = new Color(123, 63, 252);
            Color azzurro = new Color(63, 184, 255);

            GradientPaint gradient = new GradientPaint(0, 0, viola, getWidth(), getHeight(), azzurro);
            g2d.setPaint(gradient);

            g2d.fillRoundRect(0, 0, getWidth() - 1 , getHeight() - 3, 40, 40);  // Raggio di arrotondamento 40
        }
        
        @Override
        public Component getListCellRendererComponent(JList<? extends Contatto> list, Contatto contatto, int index, boolean isSelected, boolean cellHasFocus) {
            label.setText(contatto.toString().toUpperCase());
            
            if (isSelected) {
                setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
            } else {
                setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
            }

            return this;
        }
    }
    
}
