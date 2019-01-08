import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Test02 {

    public static void main(String[] args) {
        ShoppingCart shoppingcart = new ShoppingCart();
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------购物车系统-------------");
        while (true) {
            System.out.println("1.添加商品");
            System.out.println("2.删除商品");
            System.out.println("3.修改商品");
            System.out.println("4.查看商品");
            System.out.println("5.退出系统");
            System.out.println("请选择您要进行的操作：");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    shoppingcart.addMerchandise();
                    break;
                case 2:
                    shoppingcart.delMerchandise();
                    break;
                case 3:
                    shoppingcart.alterMerchandise();
                    break;
                case 4:
                    shoppingcart.showInfo();
                    break;
                case 5:
                    System.out.println("退出系统成功！");
                    System.exit(0);
                    break;
            }
        }
    }
}

// 购物车类
class ShoppingCart {
    private int id;// 编号
    private int count;// 数量
    private double price;// 价格

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ShoppingCart(int id, int count, double price) {
        super();
        this.id = id;
        this.count = count;
        this.price = price;

    }

    public ShoppingCart() {

    }

    ArrayList<ShoppingCart> list = new ArrayList<ShoppingCart>();
    Scanner sc = new Scanner(System.in);

    // 添加商品
    public void addMerchandise() {
        System.out.println("请输入商品的编号：");
        setId(sc.nextInt());
        System.out.println("请输入添加的数量：");
        setCount(sc.nextInt());
        System.out.println("请输入商品的价格：");
        setPrice(sc.nextDouble());
        list.add(new ShoppingCart(getId(), getCount(), getPrice()));
        System.out.println("添加商品成功");
    }

    // 删除商品
    public void delMerchandise() {
        System.out.println("请输入商品编号：");
        setId(sc.nextInt());
        for (int i = 0; i < list.size(); i++) {
            if (getId() == list.get(i).getId()) {
                list.remove(i);
            }
        }
        System.out.println("删除编号为" + getId() + "的商品成功");
    }

    // 修改商品
    public void alterMerchandise() {
        System.out.println("请输入商品的编号：");
        setId(sc.nextInt());
        System.out.println("请输入商品的更改数量：");
        setCount(sc.nextInt());
        System.out.println("请输入商品的单价：");
        setPrice(sc.nextDouble());
        for (int i = 0; i < list.size(); i++) {
            if (getId() == list.get(i).getId()) {
                list.set(i, new ShoppingCart(getId(), getCount(), getPrice()));
            }
        }
        System.out.println("修改商品成功");
    }

    // 显示所有商品的信息
    public void showInfo() {
        if (list.size() == 0) {
            System.out.println("你的购物车是空的，快去剁手吧！");
        } else {
            list.sort(new Comparator<ShoppingCart>() {

                @Override
                public int compare(ShoppingCart o1, ShoppingCart o2) {
                    if ((o1.getPrice() * o1.getCount()) > (o2.getPrice() * o2.getCount())) {
                        return 1;
                    } else if ((o1.getPrice() * o1.getCount()) < (o2.getPrice() * o2.getCount())) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            for (ShoppingCart shoppingcart : list) {
                System.out.println(shoppingcart);
            }
        }

    }
    // 输出
    @Override
    public String toString() {
        return "购物车 [商品编号=" + id + ", 商品数量=" + count + ", 商品单价=" + price + "，总价=" + (price * count) + "]";
    }
}
