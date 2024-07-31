/*let arr = [1, 3, 7, 2]
arr.forEach(function(item, i, array) {
    console.log(`Элемент: ${item} Индекс: ${i} Удвоенный элемент: ${item*2}`)
})*

function printText(str){
    console.log(str)
}
printText("Hello");
*
let a = +new Date()

for(let i=0; i<1000000; i++){
  console.log(0)
}

let b = +new Date()

console.log(b-a)*/

/**
 * Функция преобразует строку с временем в минуты
 * @param {string} time время в виде строки, например "02:08".
 * Может быть в диапазоне от "00:00" до "23:59".
 * @return {number} целое число в минутах. Например, time="02:08"
 * вернет 128.
 * 
 *
function timeToMinute(time){
  try{
  let hour = +time.split(":")[0]
  let minute = +time.split(":")[1]
  if(!(hour>=0 && hour<=23) || !(minute>=0 && minute<=59))
    throw new RangeError("hh:mm, 0<=hh<=23, 0<=mm<=59 ")  
    return hour
  } catch(error){
    return null;
  }

}
console.log(timeToMinute("02:08"))*/
// let admin = {
//   rules: 777,
//   isAdmin(){
//     console.log("I am admin " + this.name)
//   }
// }
// function User(name, age){
//   this.name = name;
//   this.age = age;
//   this.__proto__ = admin;
// }
// let u1 = new User("Petr", 21)
// class User{
//   constructor(name, age){
//     this.name = name;
//     this.age = age;
//   }
//   myInfo(){
//     console.log("Hello, " + this.name);
//   }
// }
// let u1 = new User("Alex", 12);

class Human {
  /**
   * 
   * @param {String} fio формат: Фамилия Имя Отчество
   * @param {String} birthday день рождения в формате "24.11.1994"
   * @param {String} numbers "номер", если больше 2 номеров, то по формату "номер1, номер2"
   * @param {int} room комната
   */
  constructor(fio, birthday, numbers, room){

    let name = fio.toLowerCase().split(" ");
    this.name = {};
    this.name.f = name[0][0].toUpperCase() + name[0].slice(1);
    this.name.n = name[1][0].toUpperCase() + name[1].slice(1);
    this.name.sn = name[2][0].toUpperCase() + name[2].slice(1);
    
    let date = birthday.split(".");
    this.date = {};
    this.date.d = +date[0];
    this.date.m = +date[1];
    this.date.y = +date[2];

    this.numbers = numbers.split(", ")

    
    this.room = +room
  }

  static month = [" января ", " февраля ", " марта ", " апреля ", " мая ", " июня ", " июля ", 
  " августа ", " сентября ", " октября ", " ноября ", " декабря "];
  /**
   * 
   * @returns Дата рождения в формате "DD месяца YYYY года"
   */
  getBirthday() {
    return `${this.date.d} ${Human.month[this.date.m]} ${this.date.y} года.`
  }
  /**
   * 
   * @param {String} _format принимает расширение файла
   * @returns возвращает имя итоговое файла Фамилия_Имя_отчество.формат
   */
  getImgSrc(_format){
    return `${this.name.f}_${this.name.n}_${this.name.sn}.${_format}`
  }

  getNumberList(allNumbers) {
    if(this.numbers.length == 0 || this.numbers[0].length == 0){
      return undefined;
    }
    if(allNumbers){
      return this.numbers.join(", ");
    } else {
      return this.numbers[0];
    }
  }

}
let human1 = new Human("Кулак Алекс Умерчевич", "24.11.2000", "9984, 8847, 5478", 524);
human1.getBirthday();
human1.getImgSrc(".src")
human1.getNumberList(true)
let a = 0x2312fdf3
console.log(a)