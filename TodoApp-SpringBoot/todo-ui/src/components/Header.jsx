import React from "react";
import { Link, NavLink } from "react-router-dom";

const Header = () => {
  return (
    <>
      <div>
        <header>
          <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-4">
            <a className="navbar-brand " href="/">
              Todo Management System
            </a>
            {/* <div className="collapse navbar-collapse " id="navbarNav">
              <ul className="navbar-nav ms-auto ">
                <li className="nav-item">
                  <NavLink className="nav-link" to="/employees">
                    Employees
                  </NavLink>
                </li>
                <li className="nav-item">
                  <NavLink className="nav-link" to="/departments">
                    Departments
                  </NavLink>
                </li>
              </ul>
            </div> */}
          </nav>
        </header>
      </div>
    </>
  );
};

export default Header;
