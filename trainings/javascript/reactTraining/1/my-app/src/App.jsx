import React from "react";


// const arrayReactElements = [
//     {name: "Alex", age:19, passport_id: 1234122323},
//     {name: "Vince", age:29, passport_id: 9238472333},
//     {name: "Bucky", age:12, passport_id: 1234122323},
//     {name: "John", age:34, passport_id: 9824723934}
// ];
// function generateKey(user) {
//     return user.name + "_" + user.age + "_" + user.passport_id;
// }
const App = () => {

    const onCliclHandler = (event) => {
        console.log('click', event);
    }
    const onChangeHandler = (event) => {
        console.log('on change', event.target.value);
    }

    return (
        <form onSubmit={(event)=>{
            console.log('submit')
        }}>
            <div>
                
                <input type="text" onChange={onChangeHandler}></input>
                <button onClick={onCliclHandler}>Нажать</button>
            </div>
        </form>
        );
    
    }
    // for(let i = 0; i < array.length; i++){
    //     const obj = array[i];
    //     arrayReactElements.push(
    //         <div>obj.hello</div>
    //     );
    // }

    //const arr = [(<div>abs</div>),(<div>zxc</div>), (<div>qwe</div>), (<div>ujk</div>)]
    // const yesa = "Umer"
    // const attr = "pill"
    // let status = null;
    // let age = 10;
    // if(age >= 18){
    //     status="Совершеннолетний"
    // } else {
    //     status="Несовершеннолетний"
    // }
    // return (
    //     <div className={attr}>
    //         <p>
    //             {test()}
    //             {status}
    //             {age >= 18 ? "Совершеннолетний" : "Несовершеннолетний"}
    //         </p>
    //         <a href="#">{yesa}</a>
    //     </div>
    // );
//     <div>
// {/* 
//             {
//                 arrayReactElements.map((user, index)=>{
//                     const key = generateKey(user);
//                     console.log(key);
//                     return (

//                         <div key={key}>

//                             {user.name}

//                         </div> 

//                     );
//                 })
//             } */}



//         </div>
    

export default App;