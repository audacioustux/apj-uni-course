<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>AudaciousTux - Tanjim Hossain</title>
    <link rel="stylesheet" href="/css/index.css" />
  </head>

  <body class="bg-pink-50 flex flex-col min-h-screen">
    <section class="bg-pink-50 flex-1 justify-center grid bg-gradient-to-b from-pink-100 to-transparent text-gray-700">
      <article class="greeting mx-auto flex flex-col justify-center font-playfair-serif">
        <img src="/img/04.png" class="object-contain object-right opacity-5 absolute w-full h-full pointer-events-none" />
        <h1>
          <span class="italic mr-2/em">Henlo!</span>
          <span aria-hidden="true">(ﾉ◕ヮ◕)ﾉ*:・ﾟ✧</span>
        </h1>
        <p class="leading-loose my-2/em">
          I'm Tanjim Hossain, a
          <span class="border-b-2 border-gray-300">Tehc Enthusiast</span><br />
          &amp; Co-Founder of
          <a href="https://nobinalo.com" target="_blank">Nobinālo</a>.
        </p>
        <nav class="h6 leading-8/em">
          <span aria-hidden="true" class="mr-4/em">༼ つ ◕_◕ ༽つ</span>
          <ul class="list-none inline-flex font-mono children:first:before:hidden children:before:mx-2/em children:before:content-['•ᴗ•']">
            <li><a href="https://github.com/audacioustux" title="@audacioustux">Github</a></li>
            <li><a href="https://fb.com/audacioustux" title="@audacioustux">Facebook</a></li>
            <li><a href="https://wiki.ubuntu.com/tanjim" title="@tanjim">Wiki</a></li>
          </ul>
        </nav>
      </article>
    </section>

    <%@include file="WEB-INF/components/page-header.jsp" %>
    <script src="//unpkg.com/alpinejs" defer></script>
  </body>
</html>
