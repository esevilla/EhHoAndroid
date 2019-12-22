
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.esevilla.eh_ho.R
import kotlinx.android.synthetic.main.fragment_sign_in.view.*

class SignInFragment : Fragment() {

    var signInInteractionListener: SignInInteractionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is SignInInteractionListener)
            signInInteractionListener = context

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view) {
            labelCreateAccount.setOnClickListener {
                goToSignUp()
            }

            buttonLogin.setOnClickListener {
                signIn()
            }
        }
    }

    private fun signIn() {
        signInInteractionListener?.onSignIn()
    }

    private fun goToSignUp() {
        signInInteractionListener?.onGoToSignUp()
    }

    interface SignInInteractionListener {
        fun onGoToSignUp()
        fun onSignIn()
    }
}
