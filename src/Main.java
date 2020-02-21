public class Main {
    public static void main(String[] args) {
        SQLiteTable sqLiteTable = new SQLiteTable("contacts", "contact_id");
        sqLiteTable.addColumn("first_name", sqLiteTable.TYPE_TEXT);
        sqLiteTable.addColumn("last_name", sqLiteTable.TYPE_TEXT, true, false);
        sqLiteTable.addColumn("email", sqLiteTable.TYPE_TEXT, true, true);
        sqLiteTable.addColumn("phone", sqLiteTable.TYPE_TEXT, true, true);
        sqLiteTable.addColumn("age", sqLiteTable.TYPE_INTEGER, true, false);
        sqLiteTable.addColumn("saldo", sqLiteTable.TYPE_REAL, true, false);

        System.out.println(sqLiteTable.getQuery());
    }
}
