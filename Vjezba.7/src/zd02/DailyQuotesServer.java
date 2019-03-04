package zd02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyQuotesServer {

	private ServerSocket serSocket;
	private String cliMsg;
	private String quote = null;

	// Daily quotes repository
	String[] quotesList = {"Create the highes, grandest vission possible for your life, because you become what you believe!",
		"When you can't find the sunshine be the one!", "The grass is greener where you water it", "Wherever life plantss you, bloom with grace!",
		"Little by little, day by day what iss meant for you WILL find its way!", "An arrow can only be sshot by pulling it backward"
				+ "When life is dragging you back with difficulties, it means it's going to lunch cou into something great. So just focus, and keep aiming!",
				"Believe, act as if, live like you already have it - it's coming!", "Begin now to be what you will be hereafter!", "Magic is believing in  yourself, if you can do that, you can make anything happen!",
				"If you want something you never had, you have to do something you've never done!", "Who looks outside, dreams; who looks inside, awakes.", "Little by little, one travels far.", "We know what we are, but know not what we may be.",
				"Difficult roads often leads to beautiful destinations.", "Ever tried, Ever failed. No matter. Try again. Fail again. Fail better and at the end you will succed!", "Ask and it will be given to you; seek and you will find; knock and door"
				+" will be opened to you.", "Always do your best - what you plant now, you will harvest later.", "If you don't like something, change it. If you can't change it, change your attitude.",
				"You don't need to see the whole staircase, just take the first step", "In three words I can sum up everything I have learned about life: it goes on.", "Try not to became a man of success, but rather try to become a man of value.",
				"Whether you believe you can do thing or not, you are right.", "Life isn't about finding yourself. Life is about creating yourself.", "Be yourself, everyone is already taken.", "Your big opportunity may be right where xou are now.",
				"One day or day one. You decide.", "They can because they think they can.", "Diligence is the mother of good fortune.", "Your mind is a powerful thing. When you fill it with positive thoughts, your life will start to change.",
				"I learned long ago, never wrestle with a pig. You get dirty, and besides, the pig likes it.", "The only thing you can get in a hurry is trouble.", "The two most important days in our life are the day you are born and the day you find out why.",
				"The less effort, the faster and more powerful you will be.", "You have to die a few times before you can really live.", "My father used to say: 'don't raise your voice, rather improve your argument'.", "You will not be punished for your anger,"
				+ " you will be punished by your anger.", "Truth, and goodness, and beauty are but different faces of the same all.", "If you tell the truth, you don't have to remember anything.", "Beware the barreness of a busy life.",
				"Do not take life too seriously. You will never get out of it alive.", "Take rest - a field that has rested gives bountiful crop.", "These are the days that must happen to you.", "Beauty begins the moment you decide to be yourself.",
				"You have power over your mind - not outside events. Realize this, and you will find strength.", "Very little is needed to make a happy life; it is all within yourself, in your way of thinking.",
				"Gratitude is not only the greatest of virtues, but the parent of all others.", "Love all, trust a few, do wrong to none.", "Pleasure in the job puts perfection in the work.", "Work in silence, let your success be your noise.",
				"The most successful people are those who are good at planning.", "There is no greatness where there is no simplicity, goodness and truth.", "If you want to make enemies, try to change something.",
				"Change alone is eternal, perpetual, immortal.", "Life is a progress, and not a station.", "Nothing is enough for the man to whom enough is too little.", "Every noble work is at first impossible.",
				"It does not matter how slowly you go as you do not stop.", "It is easy to quit smoking. I've done it hundreds of times.", "The rissk I took was calculated, but man, I am bad at math.", "If you feel like giving up, look back at how far you've come."
				, "You are not a drop in ocean, you are the entire ocean in a drop.", "Don't count the days. Make the days count."};


	public void go() throws IOException {

		serSocket = new ServerSocket();
		// Bind it with desired IP address and port
		serSocket.bind(new InetSocketAddress("127.0.0.1", 53000));
		// Check if server is running
		System.out.println("Server is running --> port: " + serSocket.getLocalPort());

		// Create object for accepting client request
		Socket clientReq = serSocket.accept();
		// Check client connection  
		String hostAddress = clientReq.getInetAddress().getHostAddress();
		System.out.println("New connection from the host" + hostAddress);

		// Create i/o streams
		InputStreamReader inStrRdr = new InputStreamReader(clientReq.getInputStream());
		// Buffering all from client side
		BufferedReader bfrInpt = new BufferedReader(inStrRdr);
		PrintWriter writerOut = new PrintWriter(clientReq.getOutputStream());
		while ((cliMsg = bfrInpt.readLine()) != null) {
			System.out.println("\r\nMessage from -> " + clientReq.getInetAddress() + " : " + cliMsg);
			// Get one quote randomly from the repository
			quote = getQuote();
			writerOut.println(quote);
			writerOut.flush();
		}


	}


	public String getQuote() {

		int randIn = (int)(Math.random() * quotesList.length);
		return quotesList[randIn];

	}


}