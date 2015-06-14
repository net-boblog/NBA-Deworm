package ui.team.advance;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.config.TableConfig;
import ui.home.HomeUI;
import ui.util.MyTable;
import ui.util.MyTableModel;
import ui.util.TablePanel;

/**
 * totalByYear 一支球队各年的数据表格
 * 
 * @author wang
 *
 */
public class TBYTablePane extends TablePanel{

	private int COLUMN_NUM = 24;
	private Object[][] list;
	private String abbr ;
	private HomeUI frame;
	TeamMore teamMore;
	
	public TBYTablePane(TableConfig cfg,Object[][] list,String abbr,HomeUI frame,TeamMore teamMore){
		super(cfg);
		this.teamMore = teamMore;
		this.abbr = abbr;
		this.frame = frame;
		this.list = list;
		this.initTable();
	}

	@Override
	protected void initTable() {
		this.columnNames = cfg.getColumnName();
		this.initData(list);

		this.dtm = new MyTableModel(data, columnNames){
	       	  
            @Override
            public Class<?> getColumnClass(int columnIndex) { 
            	if(columnIndex >= 2)
                return Double.class;
            	else return Object.class;
            }
        	
        }; 		
		
        table = new MyTable(this.dtm,this.getWidth());
        table.setRowHeight(25);
        table.setShowGrid(false);
        table.getTableHeader().setFont(new Font("华文细黑",0,12));
        table.getTableHeader().setForeground(Color.BLACK);
        table.setFont(new Font("华文细黑", 0, 12));
        table.FitTableColumns(table);
        initComponent();
        
        this.table.addMouseListener(showDataInfo());
	}
	 private MouseAdapter showDataInfo(){
	    	MouseAdapter adapter = new MouseAdapter() {
	    		 public void mouseReleased (MouseEvent e) {  
	            	 int column = table.columnAtPoint(e.getPoint());
	            	 int row = table.rowAtPoint(e.getPoint());
	            	 if(column == 0){	            		 
	            		SeasonDetail se = new SeasonDetail(frame, table.getValueAt(row, 0).toString(), abbr);
	            		teamMore.setVisible(false);
	            		System.out.println(frame.motherPanel.teamPanel.teamDetail==null);
	            		frame.motherPanel.teamPanel.add(se);
	            	 }
	             }  	    		
			};
			return adapter;
	    	
	    }

	private void initData(Object[][] list) {
		int size;
        if(list == null) size = 0;
        else size = list.length;
        
        this.data = new Object[size][COLUMN_NUM];
        for(int i=size-1; i>=0; --i){   	
            this.createRow(data[i], list[i]);
        }
	}

	private void createRow(Object[] row, Object[] vo) {
		for(int i=0;i<row.length;i++){
			row[i] = vo[i];
		}	
	}
}
