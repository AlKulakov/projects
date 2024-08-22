import React from 'react'
import "./About.css"
import { Link } from 'react-router-dom'
import Button from '../Button/Button'
import Footer from '../../Footer/Footer'

export default function About() {
  return (
    <>
        <div className="container">
            <div className="aboutField">
            <div className="about-inner">
                <div className="photo2"><img src="/photo2.jfif" alt="" className="myPhoto2" /></div>
                <div className="content">
                    <div className="content-title">
                        <h3 className="nameTitle">Aleksandr Kulakov</h3>
                        <p className="comps">Full Stack Developer</p>
                    </div>
                    <div className="aboutInfo">
                        <h3 className="">My competencies</h3>
                        <ul>
                            <li>   
                                Layout of websites of any complexity using the most modern technologies, as well as assistance in the deployment of your project
                            </li>
                            <li>
                                Refinement of an existing solution with security guarantees
                            </li>
                            <li>
                                Cooperation with companies and organizations in the field of information technology
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div className="about-bottom">
                <h3 className="my-story">
                    My story
                </h3>
                <div className="story-field">
                    <p className="">In 2022, I graduated from the University with a degree in Computer Science and Computer Engineering. This event was not only a joyful day, but also my starting point in the world
                        of information technology.</p>
                    <p className="">During my career, programming languages such as Java, JavaScript, and Python were mastered. This allowed me to expand our capabilities not only
                        professionally, but also to look more broadly at the "subcortex". 
                    </p>
                    <p className="">
                        Performing the next task, I not only receive financial benefits, but also feel strong satisfaction from the work successfully done.
                    </p>
                </div>
            </div>
            
            </div>
            <Button address={"/projects"}>See more</Button>
        </div>
        <Footer/>
    </>  
    )
}
