package cn.gyw.frame.thirdpart.poi;

import cn.gyw.frame.thirdpart.poi.model.PoiObj;
import com.google.common.collect.Maps;
import com.howbuy.hkacconline.facade.trade.hkopenacctforcounter.HkOpenAcctForCounterRequest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Excel 数据导入
 *
 */
public abstract class ExcelDataImport<T> {

    private final Map<String, String> COLUMN_INDEX = Maps.newHashMap();

    private final Map<String, Field> FIELD_CACHE = Maps.newHashMap();

    public PoiObj render(Row row) throws Exception {
        PoiObj request = new PoiObj();
        int targetIdx = 0;
        for (Map.Entry<String, String> entry : COLUMN_INDEX.entrySet()) {
            String prop = entry.getKey();
            String[] indexList = entry.getValue().split(",");
            Field field = clz.getDeclaredField(prop);
            field.setAccessible(true);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < indexList.length; i++) {
                targetIdx = Integer.parseInt(indexList[i]);
                final Cell cell = row.getCell(targetIdx);
                builder.append(getCellValueByCell(cell)).append(",");
            }
            field.set(request, builder.substring(0, builder.length() - 1));
        }
        return request;
    }

    public String getCellValueByCell(Cell cell) throws Exception {
        String cellValue = "";
        CellType cellType = cell.getCellType();
        switch (cellType) {
            case CellType.NUMERIC:
                short format = cell.getCellStyle().getDataFormat();
                if (DateUtil.isCellDateFormatted(cell)) {
                    // 日期
                    String pattern = "yyyyMMdd";
                    if (format == 20 || format == 32) {
                        pattern = "HH:mm";
                    } else if (format == 14 || format == 31 || format == 57 || format == 58) {
                        // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                        pattern= "yyyy-MM-dd";
                    }
                    // double value = cell.getNumericCellValue();
                    // Date date = DateUtil.getJavaDate(value);
                    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                    cellValue = sdf.format(cell.getDateCellValue());
                } else {
                    BigDecimal bd = BigDecimal.valueOf(cell.getNumericCellValue());
                    // 数值 这种用BigDecimal包装再获取plainString，可以防止获取到科学计数值
                    cellValue = bd.toPlainString();
                }
                break;
            case CellType.STRING:
                // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case CellType.BOOLEAN:
                // Boolean
                cellValue = cell.getBooleanCellValue() + "";
                break;
            case CellType.FORMULA:
                // 公式
                cellValue = cell.getCellFormula();
                break;
            case CellType.BLANK:
                // 空值
                cellValue = "";
                break;
            case CellType.ERROR:
                // 故障
                cellValue = "ERROR VALUE";
                break;
            default:
                cellValue = "UNKNOW VALUE";
                break;
        }
        return cellValue;

    }

    @PostConstruct
    public void init() {
        COLUMN_INDEX.put("ebrokerId", "0");
        COLUMN_INDEX.put("hboneNo", "1");

        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type actualType = parameterizedType.getActualTypeArguments()[0];
        Class<?> clz = (Class<?>) actualType;
    }
}
