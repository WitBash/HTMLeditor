package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    //панель с двумя вкладками
    private JTabbedPane tabbedPane = new JTabbedPane();
    //компонент для визуального редактирования html
    private JTextPane htmlTextPane = new JTextPane();
    //компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое)
    private JEditorPane plainTextPane = new JEditorPane();

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void init() {
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    //инициализация менб редактора
    public void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);

        getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }

    //инициализация панелей редактора
    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML",jScrollPane);
        JScrollPane jScrollPane1 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст",jScrollPane1);
        tabbedPane.setPreferredSize(new Dimension(100,100));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);

        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane,BorderLayout.CENTER);
    }

    //инициализация графического интерфейса
    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged(){

    }

    public void exit() {
        controller.exit();
    }
}
