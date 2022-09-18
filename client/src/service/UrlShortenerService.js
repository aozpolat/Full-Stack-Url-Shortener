const BASE_URL = "http://localhost:8080/v1";

export async function shorten(url) {
  const req = { url };
  let res = await fetch(BASE_URL, {
    headers: {
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify(req),
  });
  res = await res.json();
  return res.shortenedUrl;
}
