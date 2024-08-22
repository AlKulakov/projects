import React from 'react'
import Button from './Button/Button'
import { useState } from 'react'
import { fruits } from '../data'
import "./Table.css"
export default function Table() {
    const [fruitType, setFruitType] = useState("Яблоки")
    function handleClick(type) {
        setFruitType(type)
    }
  return (
    <div className="container">
        <table>
        <thead>
            <tr>
            {fruits.map((item, index) => {
                return(
                    <th key={index}><Button isActive={fruitType===item.title} onClickFunction={() => handleClick(item.title)}>{item.title}</Button></th>
                )
            })}
            </tr>
        </thead>
            {fruits.map((item) => {
                if (item.title===fruitType) {
                    return (
                        <tbody><tr><td className=""> Размеры: </td>{item.size.map((element, index) => {
                            return (<td key={index}>{element}</td>)
                        })}</tr>
                        <tr><td>Цвет: </td> <td>{item.color}</td></tr>
                        </tbody>
                    )
                } 
            })}
        </table>
    </div>
  )
}
