import { useState } from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import "./App.css";
import Main from "./components/Main";
import Result from "./components/Result";
import UrlContext from "./urlContext";

const App = () => {
  const url = useState("");
  return (
    <UrlContext.Provider value={url}>
      <div>
        <header>Url Shortener</header>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Main />} />
            <Route
              path="/result"
              element={url[0] ? <Result /> : <Navigate to="/" />}
            />
          </Routes>
        </BrowserRouter>
      </div>
    </UrlContext.Provider>
  );
};

const root = ReactDOM.createRoot(document.querySelector("#root"));

root.render(<App />);
