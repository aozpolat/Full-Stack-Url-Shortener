import { useContext, useState } from "react";
import UrlContext from "../urlContext";
import Icon from "jsx:../../arrow.svg";

const Result = () => {
  const [copyText, setCopyText] = useState("Copy");
  const [shortenedUrl] = useContext(UrlContext);

  const handleClick = () => {
    navigator.clipboard.writeText(shortenedUrl);
    setCopyText("Copied");
  };
  return (
    <div className="result">
      <Icon className="arrow" />
      <div className="url-container" onClick={handleClick}>
        <div className="url">{shortenedUrl}</div>
        <div className="info">{copyText}</div>
      </div>
    </div>
  );
};

export default Result;
