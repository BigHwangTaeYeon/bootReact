import React, { useEffect, useState } from 'react';
import './App.css';
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
function App() {

  const [value, setValue] = useState("");

  useEffect(() => {
    const script = document.createElement("script");
    script.src = "https://unpkg.com/lodash";
    script.async = true;
    document.body.appendChild(script);
  });

  return (
    <div className="App">
      <header className="App-header">

        <input value={value} onChange={({ target: { value } }) => setValue(value)} />

        <p>~~ 구분선 ~~</p>

        <input type="text" placeholder="아이디" value={id} onChange={appChange} />
        <input type="password" placeholder="비밀번호" />
        <button onClick={appClick}>로그인</button>
        {/* <input type="button"
          // onClick={() => {
          // axios({
          //   method: 'post',
          //   url: '/api/getBD0010',
          //   params: {
          //     writer: '황태연'
          //   }
          // })
          // .then(function (response) {
          //   console.log(response);
          // })
          // .catch(function (error) {
          //   console.log(error);
          // });
          // }}
        >api 호출하기</input> */}

      </header>
    </div>
  );
}

export default App;