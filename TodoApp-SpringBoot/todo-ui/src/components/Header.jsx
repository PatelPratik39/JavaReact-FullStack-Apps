import React from "react";
import { NavLink } from "react-router-dom";

const Header = () => {
  return (
    <>
      <div>
        <header>
          <nav className="navbar navbar-expand-lg navbar-dark bg-success px-4">
            <a className="navbar-brand " href="/">
              Todo Management System
            </a>
            <div className="collapse navbar-collapse " id="navbarNav">
              <ul className="navbar-nav ml-auto ">
                <li className="nav-item">
                  <NavLink className="nav-link" to="/todos">
                    Todos
                  </NavLink>
                </li>
              </ul>
            </div>
            <ul className="navbar-nav">
              <li className="nav-item">
                <NavLink to="/register" className="nav-link">
                  Register
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink className="nav-link" to="/login">
                  Login
                </NavLink>
              </li>
            </ul>
          </nav>
        </header>
      </div>
    </>
  );
};

export default Header;
