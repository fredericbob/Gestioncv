import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
  body {
    margin: 0;
    font-family: 'Arial', sans-serif;
    background-color: #f5f5f5;
  }

  h2 {
    color: #333;
  }

  p {
    color: #666;
  }

  form {
    display: flex;
    flex-direction: column;
  }

  input, button {
    padding: 10px;
    margin: 5px 0;
    border: 1px solid #ddd;
    border-radius: 5px;
  }

  button {
    background-color: #61dafb;
    border: none;
    color: white;
    cursor: pointer;
    &:hover {
      background-color: #21a1f1;
    }
  }
`;

export default GlobalStyle;
