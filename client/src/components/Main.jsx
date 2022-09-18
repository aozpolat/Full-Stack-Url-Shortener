import { useContext, useState } from "react";
import { shorten } from "../service/UrlShortenerService";
import UrlContext from "../urlContext";

const Main = () => {
  const [url, setUrl] = useState("");
  const [shortenedUrl, setShortenedUrl] = useContext(UrlContext);

  const handleSubmit = async () => {
    const result = await shorten(url);
    setShortenedUrl(result);
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
        />
        <button onClick={handleSubmit}>Shorten</button>
      </div>
    </div>
  );
};

export default Main;
