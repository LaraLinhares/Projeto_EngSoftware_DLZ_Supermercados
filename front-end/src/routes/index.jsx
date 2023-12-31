import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import useAuth from "../hooks/auth";
import AuthRoutes from "./auth.routes";
import HomeRoutes from "./home.routes";

const AppRoutes = () => {
  const { signed } = useAuth();
  return (
    <>
      {signed ? <HomeRoutes /> : <AuthRoutes />}
    </>
  );
}

export default AppRoutes;
