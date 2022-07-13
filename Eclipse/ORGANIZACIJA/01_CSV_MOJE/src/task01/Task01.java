package task01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class Task01 {
	
	static final String CSV_INPUT_FILE = "resources/task1/koordinate_tacaka.csv";
	static final String CSV_FILE_A = "resources/task1/izlaz.csv";
	static final String CSV_FILE_B = "resources/task1/izlaz_sortirano.csv";
	
	static List<Point> points = new ArrayList<Point>();
	
	public static void main(String[] args) {
		
		load_data(CSV_INPUT_FILE);
		
		for (Point p : points) {
			p.setDistance(Math.sqrt( p.getX()*p.getX() + p.getY()*p.getY() + p.getZ()*p.getZ() ));
		}
		
		save_data(CSV_FILE_A);
		Collections.sort(points, new Comparator<Point>() {
		    @Override
		    public int compare(Point z1, Point z2) {
		        if (z1.getDistance() > z2.getDistance())
		            return -1;
		        if (z1.getDistance() < z2.getDistance())
		            return 1;	
		        return 0;
		    }
		});
		save_data(CSV_FILE_B);

	}



	private static void load_data(String csvInputFile) {
		
		try(Reader reader = new FileReader(CSV_INPUT_FILE)){
			
			CsvToBean<Point> csvToBean = new CsvToBeanBuilder<Point>(reader).withType(Point.class).withSeparator(',').build();
			
			points = csvToBean.parse();

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	private static void save_data(String csvFile) {
		
		try(Writer writer = new FileWriter(csvFile)){
			
			StatefulBeanToCsv<Point> beanToCsv = new StatefulBeanToCsvBuilder<Point>(writer)
					.withSeparator('#')
					.withApplyQuotesToAll(false)
					.build();
			
			beanToCsv.write(points);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
