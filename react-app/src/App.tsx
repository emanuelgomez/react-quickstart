import React from "react";
import logo from "./logo.svg";
import { Title } from "./components/Title";

// eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types
function App() {
  return (
    <div>
      <header>
        <img width={200} height={200} src={logo} alt="logo" />
        <Title color="red">Hello!</Title>
      </header>
    </div>
  );
}

export default App;
