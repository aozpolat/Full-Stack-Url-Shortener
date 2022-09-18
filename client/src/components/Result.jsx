import { useContext } from "react";
import UrlContext from "../urlContext";

const Result = () => {
  const [shortenedUrl] = useContext(UrlContext);
  const arrow = new URL("../../arrow.svg", import.meta.url);

  return (
    <div>
      <img src={arrow} alt="dsd" />
      <div>{shortenedUrl}</div>
    </div>
  );
};

export default Result;
