import React from "react";

const UserName = (props) => {
    console.log(props);
    return (
        props.userAge > 20 ? (
            <p className='abc'>
                {props.userName}
                <button>Изменить имя</button>
            </p>
        ) : (
            <p className="abc">{props.userName}</p>
        )
    );
}