package edu.java.lab4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class RaceManager {

	private JFrame raceList;
	private DefaultTableModel model;
	private JButton save;
	private JButton open;
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton pedestal;
	private JToolBar toolBar;
	private JScrollPane scroll;
	private JTable race;
	private JComboBox team;
	private JTextField driver;
	private JButton filter;
	int selectedRow = -1;

	public void show() 
	{
		raceList = new JFrame("Список гонок");
		raceList.setSize(800, 500);
		raceList.setLocation(100, 100);
		raceList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		save = new JButton(new ImageIcon("./img/diskette.png"));
		open = new JButton(new ImageIcon("./img/open-file.png"));
		add = new JButton(new ImageIcon("./img/add (1).png"));
		edit = new JButton(new ImageIcon("./img/edit (1).png"));
		delete = new JButton(new ImageIcon("./img/minus.png"));
		pedestal = new JButton(new ImageIcon("./img/pedestal.png"));
		
		save.setToolTipText("Сохранить список");
		open.setToolTipText("Открыть список");
		add.setToolTipText("Добавить запись");
		edit.setToolTipText("Изменить запись");
		delete.setToolTipText("Удалить запись");
		pedestal.setToolTipText("Показать призеров");

		toolBar = new JToolBar("Панель инструментов");
		toolBar.add(add);
		toolBar.add(edit);
		toolBar.add(delete);
		toolBar.add(save);
		toolBar.add(open);
		toolBar.add(pedestal);
		
		raceList.setLayout(new BorderLayout());
		raceList.add(toolBar, BorderLayout.NORTH);
		
		String [] columnsRace = {"Команда","Пилот","Трасса","Дата и время","Место","Очки"};
		String [][] dataRace = {
			{"Red Bull Racing","Макс Ферстаппен","Спа-Франкоршам","28-08-2022 15:00","1","25"},
			{"Mercedes AMG Petronas","Льюис Хэмилтон","Сильверстоун","03-07-2022 15:00","2","18"},
			{"Ferrari","Шарль Леклер","Монако","29-05-2022 15:00","3","15"},
			{"McLaren","Ландо Норрис","Монца","11-09-2022 15:00","4","12"},
			{"AlphaTauri","Пьер Гасли","Будапешт","01-08-2022 15:00","5","10"},
			{"Aston Martin","Себастьян Феттель","Сочи","26-09-2022 15:00","6","8"},
			{"Alpine","Фернандо Алонсо","Барселона","22-05-2022 15:00","7","6"},
			{"Williams","Джордж Рассел","Зандворт","04-09-2022 15:00","8","4"},
			{"Haas","Мик Шумахер","Бахрейн","12-03-2022 15:00","9","2"  },
			{"Alfa Romeo","Валттери Боттас","Имола","24-04-2022 15:00","10","1"},
			{"Red Bull Racing","Серхио Перес","Мехико","30-10-2022 15:00","1","25"},
			{"Mercedes AMG Petronas","Джордж Рассел","Интерлагос","13-11-2022 15:00","2","18"},
			{"Ferrari","Карлос Сайнс","Сингапур","02-10-2022 15:00","3","15"},
			{"McLaren","Даниэль Риккардо","Шанхай","10-04-2022 15:00","4","12"},
			{"AlphaTauri","Юки Цунода","Сузука","09-10-2022 15:00","5","10"},
			{"Aston Martin","Лэнс Стролл","Баку","12-06-2022 15:00","6","8"},
			{"Alpine","Эстебан Окон","Монреаль","19-06-2022 15:00","7","6"},
			{"Williams","Николас Латифи","Абу-Даби","20-11-2022 15:00","8","4"},
			{"Haas","Кевин Магнуссен","Остин","23-10-2022 15:00","9","2"},
			{"Alfa Romeo","Гуаньюй Чжоу","Мельбурн","10-04-2022 15:00","10","1"},
			{"McLaren","Льюис Хэмилтон","Остин","08-07-2012 15:00","8","4"}};
			model = new DefaultTableModel(dataRace, columnsRace);
			race = new JTable(model);
			race.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scroll = new JScrollPane(race);
			raceList.add(scroll, BorderLayout.CENTER);
			
			team = new JComboBox(new String[]{"Команда",
			"McLaren", "Haas", "Alfa Romeo", "Williams", 
			"Red Bull Racing", "Aston Martin", "Alpine",
			"Mercedes AMG Petronas", "AlphaTauri", "Ferrari"}); 
			driver = new JTextField("Имя пилота");
			driver.setPreferredSize(new Dimension(200, 30));
			filter = new JButton("Поиск");
			JPanel filterPanel = new JPanel();
			filterPanel.add(team);
			filterPanel.add(driver);
			filterPanel.add(filter);
			
			raceList.add(filterPanel, BorderLayout.SOUTH);
			
			race.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
			{
				public void valueChanged(ListSelectionEvent e) 
				{
					if (!e.getValueIsAdjusting()) selectedRow = race.getSelectedRow();
				}
			});
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Успешно сохранено!", null, 1);
				}
			});
			open.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Открыть список", null, 1);
				}
			});
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Добавить запись", null, 1);
				}
			});
			edit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Изменить запись", null, 1);
				}
			});
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					JOptionPane.showMessageDialog(raceList, "Запись удалена", null, 1);
				}
			});
			pedestal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						if(selectedRow==-1) throw new NoRowException();
						JOptionPane.showMessageDialog(raceList, "Тройка лучших", null, 1);
					}
					catch(NoRowException ex) { JOptionPane.showMessageDialog(raceList, ex.getMessage());}
				}
			});
			driver.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e) {
						driver.selectAll();
				}
				public void focusLost(FocusEvent e) {
					if (driver.getText().isEmpty()) {
						driver.setText("Имя пилота");
					}
				}
			});
			filter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					try
					{
						checkName(driver);
						race = new JTable(new DefaultTableModel(findDriver(dataRace, driver.getText(), team.getSelectedItem()), columnsRace));
						race.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						race.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
						{
							public void valueChanged(ListSelectionEvent e) 
							{
								if (!e.getValueIsAdjusting()) selectedRow = race.getSelectedRow();
							}
						});
						raceList.remove(scroll);
						scroll = new JScrollPane(race);
						raceList.add(scroll, BorderLayout.CENTER);
						selectedRow = -1;
						raceList.revalidate();
						raceList.repaint();
					}
					catch(NullPointerException ex) { JOptionPane.showMessageDialog(raceList, ex.toString());}
					catch(NoNameException noNameEx) { JOptionPane.showMessageDialog(raceList, noNameEx.getMessage());}
				}
			});

			raceList.setVisible(true);
		}
		
		public static void main(String[] args) {
			new RaceManager().show();
		}
		
		private class NoRowException extends Exception
		{
			/**
			 * Исключение вызывается при попытке получения тройки лучших пилотов, 
			 * если не выбрана ни одна строка таблицы
			 */
			public NoRowException()
			{
				super("Не выбрано ни одной строки!");
			}
		}

		private class NoNameException extends Exception 
		{
			/**
			 * Исключение вызывается при попытке поиска, если поле поиска не изменено
			 */
			public NoNameException() 
			{
				super ("Вы не ввели имя для поиска!");
			}
		}

		private void checkName (JTextField bName) throws NoNameException,NullPointerException
		{
			String sName = bName.getText();
			if (sName.contains("Имя пилота")) throw new NoNameException();
			if (sName.length() == 0) throw new NullPointerException();
		}  
	
		private String [][] findDriver(String [][] data, String name, Object team)
		{
			int j=0;
			String[][] temp = new String[data.length][];
			for(int i = 0; i < data.length; i++)
			{
				if((data[i][1].equals(name) || name.equals("*")) && (data[i][0].equals(team) || team.equals("Команда"))) 
				{
					temp[j++]=data[i];
				}
			}
			String[][] result = new String[j][];
			for(int i = 0; i < j; i++)
			{
				result[i] = temp[i];
			}
			return result;
		}
	}
	