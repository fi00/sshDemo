package cn.coolwind.ssh.core.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 导出工具类
 * @author coolwind
 */
public class exportUtil {

    /**
     * 导出
     * @param list 导入数据
     * @return HSSFWorkbook
     */
    public static HSSFWorkbook export(List<?> list) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        sheet.setColumnWidth(0,40*256);

        if (list != null && list.size() > 0) {
            //通过反射获取对象的属性名称
            Object object = list.get(0);
            Field[] fields = object.getClass().getDeclaredFields();
            Field.setAccessible(fields,true);
            //设置第一行名称
            HSSFRow row = sheet.createRow(0);
            row.setHeight((short) 400);
            for (int g = 0; g < fields.length; g++) {
                HSSFCell cell = row.createCell(g);
                cell.setCellValue(fields[g].getName());
            }
            //填入数据
            writeData(1,sheet,list,fields);

        }
        return workbook;
    }

    /**
     * 将list里的数据填入表格
     * @param startRow 开始的行数
     * @param sheet     sheet
     * @param list      数据
     * @param fields    列名
     */
    private static void writeData(int startRow, HSSFSheet sheet, List<?> list, Field[] fields) {
        for (int i = 0; i < list.size(); i++) {
            HSSFRow row = sheet.createRow(startRow);
            Object o =  list.get(i);
            for (int j = 0; j < fields.length; j++) {
                HSSFCell cell = row.createCell(j);
                try {
                    cell.setCellValue((String) fields[j].get(o));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            startRow++;
        }
    }
}
