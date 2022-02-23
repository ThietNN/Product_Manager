import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<>();
        Product product1 = new Product("Meat",1,10000);
        Product product2 = new Product("Lamb",2,200000);
        Product product3 = new Product("Shrimp",3,100000);
        Product product4 = new Product("Lobster",4,1000000);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        System.out.println(productList.toString());

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Sửa sản phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Hiển thị danh sách sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm");
        System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
        System.out.println("7. Thoát");
        int choice;
        do {
             choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Scanner add = new Scanner(System.in);
                    System.out.println("Nhập Id sản phẩm: ");
                    int addID = Integer.parseInt(add.nextLine());
                    System.out.println("Nhập tên sản phẩm: ");
                    String addName = add.nextLine();
                    System.out.println("Nhập giá sản phẩm: ");
                    int addPrice = Integer.parseInt(add.nextLine());
                    Product newProduct = new Product(addName, addID, addPrice);
                    productList.add(newProduct);
                    break;
                case 2:
                    Scanner edit = new Scanner(System.in);
                    System.out.println("Nhập ID sản phẩm cần sửa: ");
                    int editID = findID(productList,Integer.parseInt(edit.nextLine()));
                    System.out.println("Nhập tên mới của sản phẩm: ");
                    productList.get(editID).setName(edit.nextLine());
                    System.out.println("Nhập giá mới của sản phẩm: ");
                    productList.get(editID).setPrice(Integer.parseInt(edit.nextLine()));
                    break;
                case 3:
                    Scanner del = new Scanner(System.in);
                    System.out.println("Nhập ID sản phẩm muốn xóa: ");
                    int delID = findID(productList, Integer.parseInt(del.nextLine()));
                    productList.remove(delID);
                    break;
                case 4:
                    for (Product product : productList)
                        System.out.println(product.toString());
                    break;
                case 5:
                    Scanner find = new Scanner(System.in);
                    System.out.println("Nhập tên sản phẩm cần tìm: ");
                    String findName = find.nextLine();
                    System.out.println(findByName(productList, findName).toString());
                    break;
                case 6:
                    Collections.sort(productList);
                    for (Product product : productList)
                        System.out.println(product);
                    break;
            }
        }while (choice!=7);
    }
    public static Product findByName(ArrayList<Product> productList, String name){
        int i;
        for (i = 0 ; i < productList.size() ; i++){
            if (productList.get(i).getName().equals(name))
                break;
        }
        return productList.get(i);
    }
    public static int findID(ArrayList<Product> productList, int ID){
        int result = 0;
        for (int i = 0 ; i < productList.size() ; i++){
            if (productList.get(i).getId() == ID)
                result = i;
                break;
        }
        return result;
    }
}

