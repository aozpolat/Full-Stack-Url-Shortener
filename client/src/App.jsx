import ReactDOM from "react-dom/client";
import "./App.css";

const App = () => {
  return (
    <div>
      <header>Url Shortener</header>
      <div className="input-container">
        <label htmlFor="url">Type a url</label>
        <input name="url" type="text" />
      </div>
    </div>
  );
};

const root = ReactDOM.createRoot(document.querySelector("#root"));

root.render(<App />);
