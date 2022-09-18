import ReactDOM from "react-dom/client";
import { useState } from "react";
import "./App.css";
import Main from "./components/Main";
import Result from "./components/Result";
import UrlContext from "./urlContext";

const App = () => {
  const url = useState("heeeeey");
  return (
    <UrlContext.Provider value={url}>
      <div>
        <header>Url Shortener</header>
        <Main />
        {/* <Result /> */}
      </div>
    </UrlContext.Provider>
  );
};

const root = ReactDOM.createRoot(document.querySelector("#root"));

root.render(<App />);
