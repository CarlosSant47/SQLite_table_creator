import java.util.ArrayList;

public class SQLiteTable {

    public final int TYPE_INTEGER = 1;
    public final int TYPE_TEXT = 2;
    public final int TYPE_REAL = 3;
    private String tableName;
    private ArrayList<Column> columns;

    private String namePrimaryKey;

    public SQLiteTable(String tableName, String namePrimaryKey)
    {
        this.tableName = tableName;
        this.namePrimaryKey = namePrimaryKey;
        this.columns = new ArrayList<>();

    }

    public void addColumn(String name, int typeData, boolean isNotNull, boolean isUnique)
    {
        Column column = new Column(name, typeData, isNotNull, isUnique);
        this.addColumn(column);
    }

    public void addColumn(String name, int typeData)
    {
        this.addColumn(new Column(name, typeData));
    }

    private boolean addColumn(Column column)
    {
        boolean exito = true;
        if(columns.size() > 0)
        {
            for (Column value : columns) {
                if (value.getNameColumn().matches(column.getNameColumn())) {
                    exito = false;
                    System.out.println("Error a agregado un campo con el mismo nombre");
                    break;
                }
            }
        }
        if(!exito)
            return exito;
        else{
            columns.add(column);
            return exito;
        }

    }

    public String getQuery()
    {
        String query = "";
        query = String.format("CREATE TABLE %s(%s);", this.tableName, this.generateColumns());
        return query;
    }

    public void deleteAllColumns()
    {
        this.columns = new ArrayList<>();
    }

    private String generateColumns()
    {
        String columns = "";
        String format ="%s %s %s %s,";
        columns += String.format("%s INTEGER PRIMARY KEY, ", this.namePrimaryKey);
        for (int x = 0; x < this.columns.size(); x++) {
            Column index = this.columns.get(x);
            if (x == this.columns.size() - 1) {
                format = "%s %s %s %s";
            }
            columns += String.format(format,
                    index.getNameColumn(),
                    index.getTypeData(),
                    index.isNotnull(),
                    index.isUnique());
        }
        return columns;
    }

    private class Column
    {
        private String nameColumn;
        private int typeData;
        private boolean notnull;
        private boolean unique;

        public Column(String nameColumn, int typeData) {
            this.nameColumn = nameColumn;
            this.typeData = typeData;
            this.notnull = false;
            this.unique = false;
        }

        public Column(String nameColumn, int typeData, boolean notnull, boolean unique) {
            this.nameColumn = nameColumn;
            this.typeData = typeData;
            this.notnull = notnull;
            this.unique = unique;
        }

        public Column()
        {

        }

        public String isNotnull() {
            if(this.notnull)
                return "NOT NULL";
            else
                return "";
        }

        public String isUnique() {
            if(this.unique)
                return "UNIQUE";
            else
                return "";
        }

        public String getNameColumn() {
            return nameColumn;
        }

        public void setNameColumn(String nameColumn) {
            this.nameColumn = nameColumn;
        }

        private String getTypeData() {
            String type = "";
            switch (this.typeData) {
                case TYPE_TEXT:
                    type = "TEXT";
                    break;
                case TYPE_INTEGER:
                    type = "INTEGER";
                    break;
                case TYPE_REAL:
                    type = "REAL";
                    break;
                default:
                    type = "TEXT";
                    break;
            }
            return type;
        }

        public void setTypeData(int typeData) {
            this.typeData = typeData;
        }
    }
}
