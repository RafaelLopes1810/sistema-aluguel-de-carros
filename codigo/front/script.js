// script.js
document.addEventListener('DOMContentLoaded', () => {
  const links = document.querySelectorAll('header nav a');

  // --- 1) marca o link ativo com base no arquivo atual ---
  const currentFile = window.location.pathname.split('/').pop() || 'index.html'; // ex: 'carros.html'
  links.forEach(link => {
    const href = link.getAttribute('href') || '';
    const linkFile = href.split('/').pop();

    if (linkFile === currentFile || (href === '#' && currentFile === 'index.html')) {
      link.classList.add('ativo');
    }
  });

  // --- 2) smooth scroll para âncoras internas (href que começam com '#') ---
  links.forEach(link => {
    const href = link.getAttribute('href') || '';
    if (href.startsWith('#')) {
      link.addEventListener('click', (e) => {
        e.preventDefault();
        const target = document.querySelector(href);
        if (target) {
          // anima scroll e atualiza histórico
          const offset = Math.max(0, target.getBoundingClientRect().top + window.pageYOffset - 70);
          window.scrollTo({ top: offset, behavior: 'smooth' });

          // atualiza estado ativo dos links
          links.forEach(l => l.classList.remove('ativo'));
          link.classList.add('ativo');

          history.replaceState(null, '', href);
        }
      });
    }
    // caso contrário: NÃO impedimos a navegação — o browser seguirá para a página indicada
  });

  // --- 3) exemplo seguro de feedback para formulário de login (apenas se existir) ---
  // Recomendo dar id ao form de login: <form id="loginForm">...</form>
  const loginForm = document.querySelector('#loginForm') || document.querySelector('#login form');
  if (loginForm) {
    loginForm.addEventListener('submit', (e) => {
      // se você quiser usar POST normal para backend, REMOVA o preventDefault
      e.preventDefault();

      // feedback temporário (toast)
      showToast('Login realizado (mock). Prossiga para integrar à API.', 'success');

      // se quiser redirecionar após login (mock), descomente:
      // setTimeout(() => window.location.href = 'carros.html', 800);
    });
  }

  // --- 4) botão de Modo Escuro (persistente) ---
  if (!document.getElementById('darkToggle')) {
    const toggle = document.createElement('button');
    toggle.id = 'darkToggle';
    toggle.className = 'theme-toggle';
    toggle.type = 'button';
    toggle.textContent = localStorage.getItem('theme') === 'dark' ? '☀️ Modo Claro' : '🌙 Modo Escuro';
    document.body.appendChild(toggle);

    // aplica tema salvo
    if (localStorage.getItem('theme') === 'dark') document.documentElement.classList.add('dark');

    toggle.addEventListener('click', () => {
      const isDark = document.documentElement.classList.toggle('dark');
      toggle.textContent = isDark ? '☀️ Modo Claro' : '🌙 Modo Escuro';
      localStorage.setItem('theme', isDark ? 'dark' : 'light');
    });
  }

  // --- função utilitária de toast ---
  function showToast(text, type = 'info') {
    const toast = document.createElement('div');
    toast.className = `toast toast-${type}`;
    toast.textContent = text;
    document.body.appendChild(toast);
    setTimeout(() => toast.classList.add('show'), 20);
    setTimeout(() => {
      toast.classList.remove('show');
      setTimeout(() => toast.remove(), 400);
    }, 2500);
  }
});