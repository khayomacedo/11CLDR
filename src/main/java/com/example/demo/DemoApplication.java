package com.example.demo;

import java.util.Date;

import com.example.demo.configuration.AppUser;
import com.example.demo.configuration.LoggedInUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
       
	@GetMapping("/")
        public String healthCheck(){
                return "HEALTH CHECK OK!";
        }

	@GetMapping("/secured")
	public Object secured(@LoggedInUser AppUser appUser){
		return appUser.getUser();
	}

	@GetMapping("/secured-admin")
	@PreAuthorize("hasRole('ROLE_admin')")
	public String securedAdmin(){
		return "Only admin can see  this";
	}
	
	@GetMapping("/public")
	public String pub(){
		
		return "This is public endpoint";
	}

	@GetMapping("/what-is-the-time")
	String time(){
		return new Date().toString();
	}
	
	@GetMapping("/devops")
	String turma(){
		return "Zumbi";
	}
	
	@GetMapping("/autoglass")
	String autoglass(){
		return "https://www.autoglassonline.com.br/";
	}
	
	@GetMapping("/9CLDR")
	String cldr(){
		return "Turma 9 MBA Cloud";
	}

	@GetMapping("/7DVPR")
	String DVP7(){
		return "Turma 7 MBA DEVOPS";
	}
	
	@GetMapping("/UFSCAR")
	String UFSCAR(){
		return "Turma UFSCAR 2026";
	}

	@GetMapping(value = "/11CLDR", produces = MediaType.TEXT_HTML_VALUE)
	String cldr11(){
		return """
		<!DOCTYPE html>
		<html lang="pt-BR">
		<head>
		  <meta charset="UTF-8" />
		  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		  <title>11CLDR | Cloud Engineering & Architecture</title>
		  <style>
		    :root {
		      --bg-1: #0b1320;
		      --bg-2: #12304d;
		      --card: rgba(255, 255, 255, 0.12);
		      --text: #f5f7ff;
		      --accent: #22d3ee;
		      --accent-2: #7dd3fc;
		    }

		    * { box-sizing: border-box; }

		    body {
		      margin: 0;
		      font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
		      color: var(--text);
		      background: radial-gradient(circle at top left, #1d4f7a, var(--bg-1) 55%),
		                  linear-gradient(135deg, var(--bg-1), var(--bg-2));
		      min-height: 100vh;
		      display: flex;
		      align-items: center;
		      justify-content: center;
		      padding: 24px;
		    }

		    .card {
		      width: min(980px, 100%);
		      background: var(--card);
		      backdrop-filter: blur(8px);
		      border: 1px solid rgba(255, 255, 255, 0.2);
		      border-radius: 18px;
		      overflow: hidden;
		      box-shadow: 0 20px 50px rgba(0, 0, 0, 0.35);
		      animation: rise 700ms ease-out;
		    }

		    .hero {
		      display: grid;
		      grid-template-columns: 1.1fr 1fr;
		      gap: 0;
		    }

		    .content {
		      padding: 32px;
		    }

		    .tag {
		      display: inline-block;
		      padding: 6px 12px;
		      border-radius: 999px;
		      font-size: 12px;
		      letter-spacing: 0.08em;
		      text-transform: uppercase;
		      background: rgba(34, 211, 238, 0.18);
		      color: var(--accent-2);
		      border: 1px solid rgba(125, 211, 252, 0.35);
		    }

		    h1 {
		      margin: 14px 0 10px;
		      font-size: clamp(1.6rem, 3.2vw, 2.4rem);
		      line-height: 1.2;
		    }

		    p {
		      margin: 0;
		      color: rgba(245, 247, 255, 0.9);
		      font-size: 1.04rem;
		      line-height: 1.6;
		    }

		    .image-wrap {
		      min-height: 320px;
		      background: #09111d;
		    }

		    .image-wrap img {
		      width: 100%;
		      height: 100%;
		      object-fit: cover;
		      display: block;
		    }

		    .footer {
		      border-top: 1px solid rgba(255, 255, 255, 0.18);
		      padding: 14px 20px;
		      font-size: 0.92rem;
		      color: rgba(245, 247, 255, 0.8);
		      background: rgba(0, 0, 0, 0.12);
		    }

		    @keyframes rise {
		      from { transform: translateY(14px); opacity: 0; }
		      to { transform: translateY(0); opacity: 1; }
		    }

		    @media (max-width: 820px) {
		      .hero { grid-template-columns: 1fr; }
		      .image-wrap { min-height: 230px; }
		      .content { padding: 24px; }
		    }
		  </style>
		</head>
		<body>
		  <main class="card">
		    <section class="hero">
		      <div class="content">
		        <span class="tag">11CLDR</span>
		        <h1>Turma MBA em Cloud - Engineering & Architecture</h1>
		        <p>
		          Pipeline de CI/CD, automacao de entregas e boas praticas DevOps para acelerar
		          desenvolvimento com confiabilidade, seguranca e observabilidade.
		        </p>
		      </div>
		      <div class="image-wrap">
		        <img
		          src="https://images.unsplash.com/photo-1451187580459-43490279c0fa?auto=format&fit=crop&w=1400&q=80"
		          alt="Imagem de CI/CD e DevOps"
		        />
		      </div>
		    </section>
		    <div class="footer">Deploy em Azure App Service | Endpoint: /11CLDR</div>
		  </main>
		</body>
		</html>
		""";
	}
	
}	
