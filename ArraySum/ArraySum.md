## 題目一   
計算 Luxury 裡 Price 的總和

條件 : 請使用一行程式

提示 : map , reduce

### Luxury

```json
[
    {
        "brand": "LV",
        "price": 43211
    },
    {
        "brand": "GUCCI",
        "price": 56566
    },
    {
        "brand": "HERMES",
        "price": 223378
    }
]
```
### Sample JavaScript
```js
const luxury = [
  { brand: 'LV', price: 43211 },
  { brand: 'GUCCI', price: 56566 },
  { brand: 'HERMES', price: 223378 },
];
```
### Sample Java
```java
List<Luxury> list = new ArrayList<>();
list.add(new Luxury("LV", 43211));
list.add(new Luxury("GUCCI", 56566));
list.add(new Luxury("HERMES", 223378));

class Luxury {
    String brand;
    Integer price;

    Luxury(String brand, Integer price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getPrice() {
        return price;
    }
}
```
