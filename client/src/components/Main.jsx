import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import { shorten } from "../service/UrlShortenerService";
import UrlContext from "../urlContext";

const Main = () => {
  const [url, setUrl] = useState("");
  const navigate = useNavigate();
  const [, setShortenedUrl] = useContext(UrlContext);

  const handleSubmit = async () => {
    if (url) {
      const result = await shorten(url);
      setShortenedUrl(result);
      setUrl("");
      navigate("/result");
    }
  };

  const handleKeyDown = (e) => {
    if (e.key === "Enter" && url) {
      handleSubmit();
    }
  };
  return (
    <div>
      <div className="input-container">
        <label htmlFor="url">Type a url</label>
        <input
          name="url"
          type="text"
          value={url}
          onChange={(e) => setUrl(e.target.value)}
          onKeyDown={handleKeyDown}
        />
        <button onClick={handleSubmit}>Shorten</button>
      </div>
    </div>
  );
};

export default Main;
