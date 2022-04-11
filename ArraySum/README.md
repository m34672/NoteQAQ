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

## 題目二
計算 Rich 裡所有的總和 , 並回傳新的 object
提示 : reduce

### Luxury

```json
[
    {
        "LV": 22222,
        "GUCCI": 66666,
        "HERMES": 222222
    },
    {
        "LV": 33333,
        "GUCCI": 77777,
        "HERMES": 233333
    },
    {
        "LV": 55555,
        "GUCCI": 88888,
        "HERMES": 255555
    }
]
```
### Sample JavaScript
```js
const rich = [
  { LV: 22222, GUCCI: 66666, HERMES: 222222 },
  { LV: 33333, GUCCI: 77777, HERMES: 233333 },
  { LV: 55555, GUCCI: 88888, HERMES: 255555 },
];
```
