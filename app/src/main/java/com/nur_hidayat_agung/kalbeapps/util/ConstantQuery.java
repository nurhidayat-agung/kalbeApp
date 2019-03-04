package com.nur_hidayat_agung.kalbeapps.util;

public class ConstantQuery
{
    public static String getAllCustomer = "SELECT * from Customer";
    public static String getAllBrand = "SELECT * FROM Brand";
    public static String getProduct = "SELECT * from Product INNER JOIN Brand on Product.intBrandID = Brand.intBrandID";
    public static String getSales = "SELECT Pembelian.*,Customer.txtCustomerName,Product.txtProductName from Pembelian INNER JOIN Product on Pembelian.intProductID = Product.intProductID INNER JOIN Customer on Pembelian.intCustomerID = Customer.intCustomerID";
}
