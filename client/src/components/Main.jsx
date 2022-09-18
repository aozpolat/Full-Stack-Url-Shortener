const Main = () => {
  return (
    <div>
      <div className="input-container">
        <label htmlFor="url">Type a url</label>
        <input name="url" type="text" />
        <button>Shorten</button>
      </div>
    </div>
  );
};

export default Main;
