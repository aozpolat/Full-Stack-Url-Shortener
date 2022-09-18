import ReactDOM from "react-dom/client";
import "./App.css";
import Main from "./components/Main";
import Result from "./components/Result";

const App = () => {
  return (
    <div>
      <header>Url Shortener</header>
      <Main />
      {/* <Result /> */}
    </div>
  );
};

const root = ReactDOM.createRoot(document.querySelector("#root"));

root.render(<App />);
