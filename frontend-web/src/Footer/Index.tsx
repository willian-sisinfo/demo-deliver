import React from "react";
import './styles.css';
import { ReactComponent as Youtube } from './youtube.svg'
import { ReactComponent as Insta } from './instagram.svg'
import { ReactComponent as Linkedin } from './linkedin.svg'

function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
            <div className="footer-icons">
                <a href="https://youtube.com" target="_blank">
                    <Youtube />
                </a>
                <a href="https://instagram.com" target="_blank">
                    <Insta />
                </a>
                <a href="https://linkedin.com" target="_blank">
                    <Linkedin />
                </a>
            </div>
        </footer>
    )
}
export default Footer;