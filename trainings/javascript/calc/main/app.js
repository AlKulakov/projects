let firstNumber = '0';
let letter = '';
let secondNumber = '';

const result = document.getElementById('field')

function setResult(){
    result.textContent = firstNumber + " " + letter + " " + secondNumber
}

function cancelAll(){
    firstNumber = '0'
    letter = ''
    secondNumber = ''
}

function addMinus(num){
    if(num!='')
        if(Number(num)<0)
            num=Math.abs(Number(num))
        else 
            num='-' + Number(num)
    return num
}

const number = document.getElementsByClassName("number")

for(let i = 0; i < number.length; i++){
    number[i].onclick = function() {
        if(firstNumber=='0' && number[i].textContent!='.') {
            firstNumber=number[i].textContent
        } else {
            if(letter!=''){
                if(number[i].textContent=='+/-'){
                    secondNumber = addMinus(secondNumber)
                } else {
                secondNumber+=number[i].textContent
                }
            } else {
                if(number[i].textContent=='+/-'){
                    firstNumber = addMinus(firstNumber)
                } else {
                    firstNumber+=number[i].textContent
                }
            }
        }
        setResult()
    }
}
const cancel = document.getElementById('cancel')

cancel.onclick = function(){
    cancelAll()
    setResult()
}

const back = document.getElementById('back')

back.onclick = function(){
    if(firstNumber.length==1){
        firstNumber='0'
        setResult()
    } else if(secondNumber!=''){
        secondNumber = secondNumber.slice(0,-1)
        setResult()
    } else if(secondNumber=='' && letter!=''){
        letter = letter.slice(0,-1)
        setResult()
    } else if(firstNumber.length>1){
        firstNumber = firstNumber.slice(0,-1)
        setResult()
    }
}

const sign = document.getElementsByClassName("sign")

function calculate(){
    switch(letter){
        case '+':
            firstNumber = '' + (Number(firstNumber) + Number(secondNumber))
            letter = ''
            secondNumber = ''
            break
        case '-':
            firstNumber = '' + (Number(firstNumber) - Number(secondNumber))
            letter = ''
            secondNumber = ''
            break
        case '/':
            firstNumber = '' + (Number(firstNumber) / Number(secondNumber)).toFixed(2)
            letter = ''
            secondNumber = ''
            break
        case 'X':
            firstNumber = '' + (Number(firstNumber) * Number(secondNumber))
            letter = ''
            secondNumber = ''
            break
        case '%':
            firstNumber = '' + (Number(firstNumber) % Number(secondNumber)).toFixed(2)
            letter = ''
            secondNumber = ''
            break
    }
}

for(let i = 0; i < sign.length; i++){
    sign[i].onclick = function(){
        if(secondNumber==''){
            letter = sign[i].textContent
            setResult()
        } else {
            calculate()
            letter = sign[i].textContent
            setResult()
        }
    }
}

const complete = document.getElementById("do")

complete.onclick = function(){
    if(secondNumber!=''){
        calculate()
        setResult()
    } else {
        letter = ''
        setResult()
    }
}