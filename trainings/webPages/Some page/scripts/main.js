/*
console.log("dfsdsfsdf");

let name = 5;
let famile = 6;
console.log(name+famile/5);
*/
// function isNumber(number){
//     return !isNaN(parseFloat(number)) && !isNaN(number - 0);
// }
// function randomInt(min, max){
//     return Math.floor(min + Math.random() * (max-min+1));
// }

// let arr = [5, 6, 3, 4, true, "Adss"]

// let table = {
//     "name":"Aleksandr",
//     "secondName":"Kulakov",
//     "phone":9106792045
// };

// let cars = [
//     {
//         "mark":"Toyota",
//         "model":"Corolla",
//         "year":2020,
//         "avaliable":true
//     },
//     {
//         "mark":"Nissan",
//         "model":"Quasqai",
//         "year":2016,
//         "avaliable":true
//     },
//     {
//         "mark":"Opel",
//         "model":"Astra",
//         "year":2012,
//         "avaliable":false
//     }
// ];
// alert("Внимание!");
// let a = prompt("Подтвердите ваш возраст");
// if(a!=null){
//     alert(`Ваш возраст ${a}`);
// } else {
//     alert("Нажата отмена!");
// }

// if(confirm("Вы дурачок?")){
//     alert("Да");
// }else {
//     alert("Нет");
// }
// let age = prompt("Ваш возраст: ");
// switch(true){
//     case age >= 18:
//         alert("Вы совершеннолетний");
//         break;
//     case age < 18:
//         alert("Вы несовершеннолетний");
//         break;
// }

let arr = [
        {id : 12,  name : "Alex"}, 
        {id : 32, name: "Peter"}
        ];

// for(let item of arr){
//     console.log(item);
// }
let v = arr.find(function(item){
    if(item.id==12) return item;
});
console.log(v);